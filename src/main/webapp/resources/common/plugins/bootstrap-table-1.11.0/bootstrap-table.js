/**
 * @author zhixin wen <wenzhixin2010@gmail.com>
 * version: 1.0.1
 */

!function ($) {

    'use strict';

    // TOOLS DEFINITION
    // ======================

    // it only does '%s', and return '' when arguments are undefined
    var sprintf = function(str) {
        var args = arguments,
            flag = true,
            i = 1;

        str = str.replace(/%s/g, function() {
            var arg = args[i++];

            if (typeof arg === 'undefined') {
                flag = false;
                return '';
            }
            return arg;
        });
        if (flag) {
            return str;
        }
        return '';
    };

    // BOOTSTRAP TABLE CLASS DEFINITION
    // ======================

    var BootstrapTable = function(el, options) {
        this.options = options;
        this.$el = $(el);
        this.$el_ = this.$el.clone();

        this.init();
    };

    BootstrapTable.DEFAULTS = {
        classes: 'table table-hover',
        height: undefined,
        undefinedText: '-',
        sortName: undefined,
        sortOrder: 'asc',
        striped: false,
        columns: [],
        data: [],
        method: 'get',
        url: undefined,
        queryParams: {},
        pagination: false,
        sidePagination: 'client', // client or server
        totalRows: 0, // server side need to set
        pageNumber: 1,
        pageSize: 10,
        pageList: [10, 20, 30, 40, 50],

        onClickRow: function(item) {return false;},
        onSort: function(name, order) {return false;},
        onCheck: function(row) {return false;},
        onUncheck: function(row) {return false;},
        onCheckAll: function(rows) {return false;},
        onUncheckAll: function(rows) {return false;}
    };

    BootstrapTable.prototype.init = function() {
        this.initContainer();
        this.initHeader();
        this.initData();
        this.initPagination();
        this.initBody();
        this.initServer();
    };

    BootstrapTable.prototype.initContainer = function() {
        this.$container = $([
            '<div class="fixed-table-container">',
                '<div class="fixed-table-header"></div>',
                '<div class="fixed-table-body"></div>',
                '<div class="fixed-table-pagination"></div>',
            '</div>'].join(''));
        this.$container.insertAfter(this.$el);
        this.$container.find('.fixed-table-body').append(this.$el);
        this.$container.after('<div class="clearfix"></div>');

        if (this.options.height) {
            this.$container.css('height', this.options.height + 'px');
        }
        this.$el.addClass(this.options.classes);
        if (this.options.striped) {
            this.$el.addClass('table-striped');
        }
    };

    BootstrapTable.prototype.initHeader = function() {
        var that = this,
            columns = [],
            html = [];

        this.$header = this.$el.find('thead');
        if (!this.$header.length) {
            this.$header = $('<thead></thead>').appendTo(this.$el);
        }
        if (!this.$header.find('tr').length) {
            this.$header.append('<tr></tr>');
        }
        this.$header.find('th').each(function() {
            var column = $.extend({}, {
                title: $(this).text()
            }, $(this).data());

            columns.push(column);
        });
        this.options.columns = $.extend(columns, this.options.columns);

        this.header = {
            fields: [],
            styles: [],
            formatters: [],
            sorters: []
        };
        $.each(this.options.columns, function(i, column) {
            var text = '',
                style = sprintf('text-align: %s; ', column.align) + sprintf('vertical-align: %s; ', column.valign),
                order = that.options.sortOrder || column.order || 'asc';

            that.header.fields.push(column.field);
            that.header.styles.push(style);
            that.header.formatters.push(column.formatter);
            that.header.sorters.push(column.sorter);

            style = sprintf('width: %spx; ', column.checkbox || column.radio ? 36 : column.width);
            style += column.sortable ? 'cursor: pointer; ' : '';

            html.push('<th' + sprintf(' style="%s"', style) + '>');
            html.push('<div class="th-inner">');

            text = column.title;
            if (that.options.sortName === column.field && column.sortable) {
                text += that.getCaretHtml();
            }

            if (column.checkbox) {
                text = '<input name="btSelectAll" type="checkbox" class="checkbox" />';
                that.header.stateField = column.field;
            }
            if (column.radio) {
                text = '';
                that.header.stateField = column.field;
            }

            html.push(text);
            html.push('</div>');
            html.push('</th>');
        });

        this.$header.find('tr').html(html.join(''));
        this.$header.find('th').each(function(i) {
            $(this).data(columns[i]);

            if (columns[i].sortable) {
                $(this).click($.proxy(that.onSort, that));
            }
        });
        this.$selectAll = this.$header.find('[name="btSelectAll"]');
        this.$selectAll.off('click').on('click', function() {
            var checked = $(this).prop('checked');
            that[checked ? 'checkAll' : 'uncheckAll']();
        });
    };

    BootstrapTable.prototype.initData = function(data, append) {
        if (append) {
            this.data = this.data.concat(data);
        } else {
            this.data = data || this.options.data;
        }

        this.initSort();
    };

    BootstrapTable.prototype.initSort = function() {
        var name = this.options.sortName,
            order = this.options.sortOrder === 'desc' ? -1 : 1,
            index = $.inArray(this.options.sortName, this.header.fields);

        if (index !== -1) {
            var sorter = this.header.sorters[index];
            this.data.sort(function(a, b) {
                if (typeof sorter === 'function') {
                    return order * sorter(a[name], b[name]);
                }
                if (typeof sorter === 'string') {
                    return order * eval(sorter + '(a[name], b[name])'); // eval ?
                }
                if (a[name] === b[name]) {
                    return 0;
                }
                if (a[name] < b[name]) {
                    return order * -1;
                }
                return order;
            });
        }
    };

    BootstrapTable.prototype.onSort = function(event) {
        var $this = $(event.currentTarget);

        this.$header.find('span.order').remove();
        this.options.sortName = $this.data('field');
        this.options.sortOrder = $this.data('order') === 'asc' ? 'desc' : 'asc';
        this.options.onSort(this.options.sortName, this.options.sortOrder);

        $this.data('order', this.options.sortOrder);
        $this.find('.th-inner').append(this.getCaretHtml());

        this.initSort();
        this.initBody();
    };

    BootstrapTable.prototype.initPagination = function() {
        if (!this.options.pagination) {
            return;
        }

        this.$pagination = this.$container.find('.fixed-table-pagination');

        if (this.options.sidePagination === 'client') {
            this.options.totalRows = this.data.length;
        }
        this.updatePagination();
    };

    BootstrapTable.prototype.updatePagination = function() {
        var that = this,
            html = [],
            i, from, to,
            $pageList,
            $first, $pre,
            $next, $last,
            $number;

        this.totalPages = 0;
        if (this.options.totalRows) {
            this.totalPages = ~~((this.options.totalRows - 1) / this.options.pageSize) + 1;
        }
        if (this.totalPages > 0 && this.options.pageNumber > this.totalPages) {
            this.options.pageNumber = this.totalPages;
        }
        this.pageFrom = (this.options.pageNumber - 1) * this.options.pageSize + 1;
        this.pageTo = this.options.pageNumber * this.options.pageSize;
        if (this.pageTo > this.options.totalRows) {
            this.pageTo = this.options.totalRows;
        }
        html.push(
            '<div class="pull-left pagination">',
                '<div class="pagination-info">',
                    sprintf('Showing %s to %s of %s rows', this.pageFrom, this.pageTo, this.options.totalRows),
                '</div>',
            '</div>',
            '<div class="pull-right">',
                '<ul class="pagination">',
                    '<li class="page-first"><a href="javascript:void(0)">&lt;&lt;</a></li>',
                    '<li class="page-pre"><a href="javascript:void(0)">&lt;</a></li>');

        if (this.totalPages < 5) {
            from = 1;
            to = this.totalPages;
        } else {
            from = this.options.pageNumber - 2;
            to = from + 4;
            if (from < 1) {
                from = 1;
                to = 5;
            }
            if (to > this.totalPages) {
                to = this.totalPages;
                from = to - 4;
            }
        }
        for (i = from; i <= to; i++) {
            html.push('<li class="page-number' + (i === this.options.pageNumber ? ' active' : '') + '">',
                '<a href="javascript:void(0)">', i ,'</a>',
                '</li>');
        }

        html.push(
                    '<li class="page-next"><a href="javascript:void(0)">&gt;</a></li>',
                    '<li class="page-last"><a href="javascript:void(0)">&gt;&gt;</a></li>',
                '</ul>',
            '</div>');

        html.push(
            '<div class="pagination btn-group dropup page-list">',
                '<button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">',
                    this.options.pageSize,
                    ' <span class="caret"></span>',
                '</button>',
                '<ul class="dropdown-menu" role="menu">');
        $.each(this.options.pageList, function(i, page) {
            var active = page === that.options.pageSize ? ' class="active"' : '';
            html.push(sprintf('<li%s><a href="javascript:void(0)">%s</a></li>', active, page));
        });
        html.push(
                '</ul>',
            '</div>');

        this.$pagination.html(html.join(''));

        $pageList = this.$pagination.find('.page-list a');
        $first = this.$pagination.find('.page-first');
        $pre = this.$pagination.find('.page-pre');
        $next = this.$pagination.find('.page-next');
        $last = this.$pagination.find('.page-last');
        $number = this.$pagination.find('.page-number');

        if (this.options.pageNumber <= 1) {
            $first.addClass('disabled');
            $pre.addClass('disabled');
        }
        if (this.options.pageNumber >= this.totalPages) {
            $next.addClass('disabled');
            $last.addClass('disabled');
        }
        $pageList.off('click').on('click', $.proxy(this.onPageListChange, this));
        $first.off('click').on('click', $.proxy(this.onPageFirst, this));
        $pre.off('click').on('click', $.proxy(this.onPagePre, this));
        $next.off('click').on('click', $.proxy(this.onPageNext, this));
        $last.off('click').on('click', $.proxy(this.onPageLast, this));
        $number.off('click').on('click', $.proxy(this.onPageNumber, this));
    };

    BootstrapTable.prototype.onPageListChange = function(event) {
        this.options.pageSize = +$(event.currentTarget).text();
        this.updatePagination();
        this.initBody();
    };

    BootstrapTable.prototype.onPageFirst = function() {
        this.options.pageNumber = 1;
        this.updatePagination();
        this.initBody();
    };

    BootstrapTable.prototype.onPagePre = function() {
        this.options.pageNumber--;
        this.updatePagination();
        this.initBody();
    };

    BootstrapTable.prototype.onPageNext = function() {
        this.options.pageNumber++;
        this.updatePagination();
        this.initBody();
    };

    BootstrapTable.prototype.onPageLast = function() {
        this.options.pageNumber = this.totalPages;
        this.updatePagination();
        this.initBody();
    };

    BootstrapTable.prototype.onPageNumber = function(event) {
        this.options.pageNumber = +$(event.currentTarget).text();
        this.updatePagination();
        this.initBody();
    };

    BootstrapTable.prototype.initBody = function() {
        var that = this,
            html = [];

        this.$body = this.$el.find('tbody');
        if (!this.$body.length) {
            this.$body = $('<tbody></tbody>').appendTo(this.$el);
        }

        if (!this.options.pagination) {
            this.pageFrom = 1;
            this.pageTo = this.data.length;
        }

        for (var i = this.pageFrom - 1; i < this.pageTo; i++) {
            var item = this.data[i];

            html.push('<tr' + ' data-index="' + i + '">');

            $.each(that.header.fields, function(j, field) {
                var text = '',
                    value = item[field],
                    type = '';

                if (typeof that.header.formatters[j] === 'function') {
                    value = that.header.formatters[j](value, item);
                }

                text = ['<td' + sprintf(' style="%s"', that.header.styles[j]) + '>',
                    typeof value === 'undefined' ? that.options.undefinedText : value,
                    '</td>'].join('');

                if (that.options.columns[j].checkbox || that.options.columns[j].radio) {
                    type = that.options.columns[j].checkbox ? 'checkbox' : type;
                    type = that.options.columns[j].radio ? 'radio' : type;

                    text = ['<td>',
                        '<input name="btSelectItem" class="checkbox" data-index="' + i + '"' +
                            sprintf(' type="%s"', type) +
                            sprintf(' checked="%s"', value ? 'checked' : undefined) + ' />',
                        '</td>'].join('');
                }
                html.push(text);
            });

            html.push('</tr>');
        }

        this.$body.html(html.join(''));

        this.$body.find('tr').off('click').on('click', function() {
            that.options.onClickRow(that.data[$(this).data('index')]);
        });

        this.$selectItem = this.$body.find('[name="btSelectItem"]');
        this.$selectItem.off('click').on('click', function() {
            var checkAll = that.data.length === that.$selectItem.filter(':checked').length;
            that.$selectAll.prop('checked', checkAll);
            that.data[$(this).data('index')][that.header.stateField] = $(this).prop('checked');
        });
        this.resetView();
    };

    BootstrapTable.prototype.initServer = function() {
        var that = this;

        if (!this.options.url) {
            return;
        }
        $.ajax({
            type: this.options.method,
            url: this.options.url,
            data: this.options.queryParams,
            contentType: 'application/json',
            dataType: 'json',
            success: function(data) {
                that.load(data);
            }
        });
    };

    BootstrapTable.prototype.getCaretHtml = function() {
        return ['<span class="order' + (this.options.sortOrder === 'desc' ? '' : ' dropup') + '">',
                '<span class="caret" style="margin: 10px 5px;"></span>',
            '</span>'].join('');
    };

    BootstrapTable.prototype.resetView = function() {
        var header = this.header;

        this.$header.find('.th-inner').each(function(i) {
            $(this).attr('style', header.styles[i])
                .css('width', ($(this).parent().width()) + 'px'); // padding: 8px
        });
    };

    BootstrapTable.prototype.updateRows = function(checked) {
        var that = this;

        $.each(this.data, function(i, row) {
            row[that.header.stateField] = checked;
        });
    };

    // PUBLIC FUNCTION DEFINITION
    // =======================

    BootstrapTable.prototype.load = function(data) {
        this.initData(data);
        this.initPagination();
        this.initBody();
    };

    BootstrapTable.prototype.append = function(data) {
        this.initData(data, true);
        this.initBody();
    };

    BootstrapTable.prototype.mergeCells = function(options) {
        var row = options.index,
            col = $.inArray(options.field, this.header.fields),
            rowspan = options.rowspan || 1,
            colspan = options.colspan || 1,
            i, j,
            $tr = this.$body.find('tr'),
            $td = $tr.eq(row).find('td').eq(col);

        if (row < 0 || col < 0 || row >= this.data.length) {
            return;
        }

        for (i = row; i < row + rowspan; i++) {
            for (j = col; j < col + colspan; j++) {
                $tr.eq(i).find('td').eq(j).hide();
            }
        }

        $td.attr('rowspan', rowspan).attr('colspan', colspan).show();
    };

    BootstrapTable.prototype.getSelections = function() {
        var that = this;

        return $.grep(this.data, function(row) {
            return row[that.header.stateField];
        });
    };

    BootstrapTable.prototype.checkAll = function() {
        this.$selectAll.prop('checked', true);
        this.$selectItem.prop('checked', true);
        this.updateRows(true);
    };

    BootstrapTable.prototype.uncheckAll = function() {
        this.$selectAll.prop('checked', false);
        this.$selectItem.prop('checked', false);
        this.updateRows(false);
    };

    BootstrapTable.prototype.destroy = function() {
        this.$container.replaceWith(this.$el_);
        return this.$el_;
    };


    // BOOTSTRAP TABLE PLUGIN DEFINITION
    // =======================

    $.fn.bootstrapTable = function(option, _relatedTarget) {
        var allowedMethods = [
                'getSelections',
                'load', 'append', 'mergeCells',
                'checkAll', 'uncheckAll',
                'destroy'
            ],
            value;

        this.each(function() {
            var $this = $(this),
                data = $this.data('bootstrap.table'),
                options = $.extend({}, BootstrapTable.DEFAULTS, $this.data(), typeof option === 'object' && option);

            if (!data) {
                $this.data('bootstrap.table', (data = new BootstrapTable(this, options)));
            }

            if (typeof option === 'string') {
                if ($.inArray(option, allowedMethods) < 0) {
                    throw "Unknown method: " + option;
                }
                value = data[option](_relatedTarget);
            }
        });

        return value ? value : this;
    };

    $.fn.bootstrapTable.Constructor = BootstrapTable;

    // BOOTSTRAP TABLE INIT
    // =======================
    var sprintf = function (str) {
        var args = arguments,
            flag = true,
            i = 1;

        str = str.replace(/%s/g, function () {
            var arg = args[i++];

            if (typeof arg === 'undefined') {
                flag = false;
                return '';
            }
            return arg;
        });
        return flag ? str : '';
    };

    var getFieldIndex = function (columns, field) {
        var index = -1;

        $.each(columns, function (i, column) {
            if (column.field === field) {
                index = i;
                return false;
            }
            return true;
        });
        return index;
    };

    var calculateObjectValue = function (self, name, args, defaultValue) {
        var func = name;

        if (typeof name === 'string') {
            var names = name.split('.');

            if (names.length > 1) {
                func = window;
                $.each(names, function (i, f) {
                    func = func[f];
                });
            } else {
                func = window[name];
            }
        }
        if (typeof func === 'object') {
            return func;
        }
        if (typeof func === 'function') {
            return func.apply(self, args);
        }
        if (!func && typeof name === 'string' && sprintf.apply(this, [name].concat(args))) {
            return sprintf.apply(this, [name].concat(args));
        }
        return defaultValue;
    };

    var getItemField = function (item, field) {
        var value = item;

        if (typeof field !== 'string' || item.hasOwnProperty(field)) {
            return item[field];
        }
        var props = field.split('.');
        for (var p in props) {
            value = value[props[p]];
        }
        return value;
    };

    var getParent = function (node, source, field) {
        var data = [];
        var items = $.grep(source, function (item, index) {
            return node.ParentId == item[field];
        });
        $.each(items, function (index, item) {
            data.splice(0, 0, item);
            var child = getParent(item, source, field);
            $.each(child, function (i, n) {
                data.splice(0, 0, n);
            });
        });
        return data;
    };

    var getChild = function (node, source, field) {
        var data = [];
        var items = $.grep(source, function (item, index) {
            return item.ParentId == node[field];
        });

        $.each(items, function (index, item) {
            data.push(item);
            var child = getChild(item, source, field);
            $.each(child, function (i, n) {
                data.push(n);
            });
        });
        return data;
    };

    //调用bootstrapTable组件的构造器得到对象
    var BootstrapTable = $.fn.bootstrapTable.Constructor,
        _initData = BootstrapTable.prototype.initData,
        _initPagination = BootstrapTable.prototype.initPagination,
        _initBody = BootstrapTable.prototype.initBody;

    //重写bootstrapTable的initData方法
    BootstrapTable.prototype.initData = function () {
        _initData.apply(this, Array.prototype.slice.apply(arguments));
        var that = this;
        if (that.options.treeView && this.data.length > 0) {
            var rows = [];
            var roots = $.grep(this.data, function (row, index) {
                return row.Level == that.options.treeRootLevel;
            });
            $.each(roots, function (index, item) {
                rows.push(item);
                var child = getChild(item, that.data, that.options.treeId);
                $.each(child, function (i, n) {
                    if (that.options.treeCollapseAll) {
                        n.hidden = true;
                    }
                    rows.push(n);
                });
            });
            that.options.data = that.data = rows;
        }
    };

    //重写bootstrapTable的initPagination方法
    BootstrapTable.prototype.initPagination = function () {
        //理论情况下，treegrid是不支持分页的，所以默认分页参数为false
        this.options.pagination = false;
        //调用“父类”的“虚方法”
        _initPagination.apply(this, Array.prototype.slice.apply(arguments));
    };

    //重写bootstrapTable的initBody方法
    BootstrapTable.prototype.initBody = function (fixedScroll) {
        var that = this,
            html = [],
            data = this.getData();

        this.trigger('pre-body', data);

        this.$body = this.$el.find('tbody');
        if (!this.$body.length) {
            this.$body = $('<tbody></tbody>').appendTo(this.$el);
        }

        if (!this.options.pagination || this.options.sidePagination === 'server') {
            this.pageFrom = 1;
            this.pageTo = data.length;
        }

        for (var i = this.pageFrom - 1; i < this.pageTo; i++) {
            var key,
                item = data[i],
                style = {},
                csses = [],
                data_ = '',
                attributes = {},
                htmlAttributes = [];
            if (item.hidden) continue;

            style = calculateObjectValue(this.options, this.options.rowStyle, [item, i], style);

            if (style && style.css) {
                for (key in style.css) {
                    csses.push(key + ': ' + style.css[key]);
                }
            }

            attributes = calculateObjectValue(this.options,
                this.options.rowAttributes, [item, i], attributes);

            if (attributes) {
                for (key in attributes) {
                    htmlAttributes.push(sprintf('%s="%s"', key, escapeHTML(attributes[key])));
                }
            }

            if (item._data && !$.isEmptyObject(item._data)) {
                $.each(item._data, function (k, v) {
                    if (k === 'index') {
                        return;
                    }
                    data_ += sprintf(' data-%s="%s"', k, v);
                });
            }

            html.push('<tr',
                sprintf(' %s', htmlAttributes.join(' ')),
                sprintf(' id="%s"', $.isArray(item) ? undefined : item._id),
                sprintf(' class="%s"', style.classes || ($.isArray(item) ? undefined : item._class)),
                sprintf(' data-index="%s"', i),
                sprintf(' data-uniqueid="%s"', item[this.options.uniqueId]),
                sprintf('%s', data_),
                '>'
            );

            if (this.options.cardView) {
                html.push(sprintf('<td colspan="%s">', this.header.fields.length));
            }

            if (!this.options.cardView && this.options.detailView) {
                html.push('<td>',
                    '<a class="detail-icon" href="javascript:">',
                    sprintf('<i class="%s %s"></i>', this.options.iconsPrefix, this.options.icons.detailOpen),
                    '</a>',
                    '</td>');
            }

            $.each(this.header.fields, function (j, field) {
                var text = '',
                    value = getItemField(item, field),
                    type = '',
                    cellStyle = {},
                    id_ = '',
                    class_ = that.header.classes[j],
                    data_ = '',
                    rowspan_ = '',
                    title_ = '',
                    column = that.columns[getFieldIndex(that.columns, field)];

                if (!column.visible) {
                    return;
                }

                style = sprintf('style="%s"', csses.concat(that.header.styles[j]).join('; '));

                value = calculateObjectValue(column,
                    that.header.formatters[j], [value, item, i], value);

                if (item['_' + field + '_id']) {
                    id_ = sprintf(' id="%s"', item['_' + field + '_id']);
                }
                if (item['_' + field + '_class']) {
                    class_ = sprintf(' class="%s"', item['_' + field + '_class']);
                }
                if (item['_' + field + '_rowspan']) {
                    rowspan_ = sprintf(' rowspan="%s"', item['_' + field + '_rowspan']);
                }
                if (item['_' + field + '_title']) {
                    title_ = sprintf(' title="%s"', item['_' + field + '_title']);
                }
                cellStyle = calculateObjectValue(that.header,
                    that.header.cellStyles[j], [value, item, i], cellStyle);
                if (cellStyle.classes) {
                    class_ = sprintf(' class="%s"', cellStyle.classes);
                }
                if (cellStyle.css) {
                    var csses_ = [];
                    for (var key in cellStyle.css) {
                        csses_.push(key + ': ' + cellStyle.css[key]);
                    }
                    style = sprintf('style="%s"', csses_.concat(that.header.styles[j]).join('; '));
                }

                if (item['_' + field + '_data'] && !$.isEmptyObject(item['_' + field + '_data'])) {
                    $.each(item['_' + field + '_data'], function (k, v) {
                        if (k === 'index') {
                            return;
                        }
                        data_ += sprintf(' data-%s="%s"', k, v);
                    });
                }

                if (column.checkbox || column.radio) {
                    type = column.checkbox ? 'checkbox' : type;
                    type = column.radio ? 'radio' : type;

                    text = [that.options.cardView ?
                        '<div class="card-view">' : '<td class="bs-checkbox">',
                        '<input' +
                        sprintf(' data-index="%s"', i) +
                        sprintf(' name="%s"', that.options.selectItemName) +
                        sprintf(' type="%s"', type) +
                        sprintf(' value="%s"', item[that.options.idField]) +
                        sprintf(' checked="%s"', value === true ||
                        (value && value.checked) ? 'checked' : undefined) +
                        sprintf(' disabled="%s"', !column.checkboxEnabled ||
                        (value && value.disabled) ? 'disabled' : undefined) +
                        ' />',
                        that.header.formatters[j] && typeof value === 'string' ? value : '',
                        that.options.cardView ? '</div>' : '</td>'
                    ].join('');

                    item[that.header.stateField] = value === true || (value && value.checked);
                } else {

                    value = typeof value === 'undefined' || value === null ?
                        that.options.undefinedText : value;
                    var indent, icon;
                    if (that.options.treeView && column.field == that.options.treeField) {
                        var indent = item.Level == that.options.Level ? '' : sprintf('<span style="margin-left: %spx;"></span>', (item.Level - that.options.treeRootLevel) * 15);
                        var child = $.grep(data, function (d, i) {
                            return d.ParentId == item[that.options.treeId] && !d.hidden;
                        });
                        icon = sprintf('<span class="tree-icon %s" style="cursor: pointer; margin: 0px 5px;"></span>', child.length > 0 ? that.options.expandIcon : that.options.collapseIcon);
                        //icon = sprintf('<span class="tree-icon %s" style="cursor: pointer; margin: 0px 5px;"></span>', child.length > 0 ? that.options.expandIcon : "");
                    }
                    text = that.options.cardView ? ['<div class="card-view">',
                        that.options.showHeader ? sprintf('<span class="title" %s>%s</span>', style,
                            getPropertyFromOther(that.columns, 'field', 'title', field)) : '',
                        sprintf('<span class="value">%s</span>', value),
                        '</div>'
                    ].join('') : [sprintf('<td%s %s %s %s %s %s>', id_, class_, style, data_, rowspan_, title_),
                        indent,
                        icon,
                        value,
                        '</td>'
                    ].join('');

                    if (that.options.cardView && that.options.smartDisplay && value === '') {
                        text = '';
                    }
                }

                html.push(text);
            });

            if (this.options.cardView) {
                html.push('</td>');
            }

            html.push('</tr>');
        }

        if (!html.length) {
            html.push('<tr class="no-records-found">',
                sprintf('<td colspan="%s">%s</td>',
                    this.$header.find('th').length, this.options.formatNoMatches()),
                '</tr>');
        }

        this.$body.html(html.join(''));

        if (!fixedScroll) {
            this.scrollTo(0);
        }

        this.$body.find('> tr[data-index] > td').off('click dblclick').on('click dblclick', function (e) {
            var $td = $(this),
                $tr = $td.parent(),
                item = that.data[$tr.data('index')],
                index = $td[0].cellIndex,
                field = that.header.fields[that.options.detailView && !that.options.cardView ? index - 1 : index],
                column = that.columns[getFieldIndex(that.columns, field)],
                value = getItemField(item, field);

            if ($td.find('.detail-icon').length) {
                return;
            }

            that.trigger(e.type === 'click' ? 'click-cell' : 'dbl-click-cell', field, value, item, $td);
            that.trigger(e.type === 'click' ? 'click-row' : 'dbl-click-row', item, $tr);

            if (e.type === 'click' && that.options.clickToSelect && column.clickToSelect) {
                var $selectItem = $tr.find(sprintf('[name="%s"]', that.options.selectItemName));
                if ($selectItem.length) {
                    $selectItem[0].click();
                }
            }
        });

        this.$body.find('> tr[data-index] > td > .detail-icon').off('click').on('click', function () {
            debugger;
            var $this = $(this),
                $tr = $this.parent().parent(),
                index = $tr.data('index'),
                row = data[index];

            if ($tr.next().is('tr.detail-view')) {
                $this.find('i').attr('class', sprintf('%s %s', that.options.iconsPrefix, that.options.icons.detailOpen));
                $tr.next().remove();
                that.trigger('collapse-row', index, row);
            } else {
                $this.find('i').attr('class', sprintf('%s %s', that.options.iconsPrefix, that.options.icons.detailClose));
                $tr.after(sprintf('<tr class="detail-view"><td colspan="%s">%s</td></tr>',
                    $tr.find('td').length, calculateObjectValue(that.options,
                        that.options.detailFormatter, [index, row], '')));
                that.trigger('expand-row', index, row, $tr.next().find('td'));
            }
            that.resetView();
        });

        this.$body.find('> tr[data-index] > td > .tree-icon').off('click').on('click', function (e) {
            debugger;
            e.stopPropagation();
            var $this = $(this),
                $tr = $this.parent().parent(),
                index = $tr.data('index'),
                row = data[index];
            var icon = $(this);
            var child = getChild(data[index], data, that.options.treeId);
            $.each(child, function (i, c) {
                $.each(that.data, function (index, item) {
                    if (item[that.options.treeId] == c[that.options.treeId]) {
                        item.hidden = icon.hasClass(that.options.expandIcon);
                        that.uncheck(index);
                        return;
                    }
                });
            });
            if (icon.hasClass(that.options.expandIcon)) {
                icon.removeClass(that.options.expandIcon).addClass(that.options.collapseIcon);
            } else {
                icon.removeClass(that.options.collapseIcon).addClass(that.options.expandIcon);
            }
            that.options.data = that.data;
            that.initBody(true);
        });

        this.$selectItem = this.$body.find(sprintf('[name="%s"]', this.options.selectItemName));
        this.$selectItem.off('click').on('click', function (event) {
            event.stopImmediatePropagation();

            var $this = $(this),
                checked = $this.prop('checked'),
                row = that.data[$this.data('index')];

            if (that.options.maintainSelected && $(this).is(':radio')) {
                $.each(that.options.data, function (i, row) {
                    row[that.header.stateField] = false;
                });
            }

            row[that.header.stateField] = checked;

            if (that.options.singleSelect) {
                that.$selectItem.not(this).each(function () {
                    that.data[$(this).data('index')][that.header.stateField] = false;
                });
                that.$selectItem.filter(':checked').not(this).prop('checked', false);
            }

            that.updateSelected();
            that.trigger(checked ? 'check' : 'uncheck', row, $this);
        });

        $.each(this.header.events, function (i, events) {
            if (!events) {
                return;
            }
            if (typeof events === 'string') {
                events = calculateObjectValue(null, events);
            }

            var field = that.header.fields[i],
                fieldIndex = $.inArray(field, that.getVisibleFields());

            if (that.options.detailView && !that.options.cardView) {
                fieldIndex += 1;
            }

            for (var key in events) {
                that.$body.find('tr').each(function () {
                    var $tr = $(this),
                        $td = $tr.find(that.options.cardView ? '.card-view' : 'td').eq(fieldIndex),
                        index = key.indexOf(' '),
                        name = key.substring(0, index),
                        el = key.substring(index + 1),
                        func = events[key];

                    $td.find(el).off(name).on(name, function (e) {
                        var index = $tr.data('index'),
                            row = that.data[index],
                            value = row[field];

                        func.apply(this, [e, value, row, index]);
                    });
                });
            }
        });

        this.updateSelected();
        this.resetView();

        this.trigger('post-body');
    };


    //给组件增加默认参数列表
    $.extend($.fn.bootstrapTable.defaults, {
        treeView: false,//treeView视图
        treeField: "id",//treeView视图字段
        treeId: "id",
        treeRootLevel: 0,//根节点序号
        treeCollapseAll: false,//是否全部展开
        collapseIcon: "glyphicon glyphicon-chevron-right",//折叠样式
        expandIcon: "glyphicon glyphicon-chevron-down"//展开样式
    });

    $(function() {
        $('[data-toggle="table"]').bootstrapTable();
    });

}(jQuery);
