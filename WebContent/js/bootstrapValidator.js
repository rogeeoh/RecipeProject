/*!
 * BootstrapValidator (http://bootstrapvalidator.com)
 * The best jQuery plugin to validate form fields. Designed to use with Bootstrap 3
 *
 * @version     v0.5.2, built on 2014-09-25 4:01:07 PM
 * @author      https://twitter.com/nghuuphuoc
 * @copyright   (c) 2013 - 2014 Nguyen Huu Phuoc
 * @license     MIT
 */
if ("undefined" == typeof jQuery) throw new Error("BootstrapValidator's JavaScript requires jQuery");
! function(a) {
    var b = function(b, c) {
        this.$form = a(b), this.options = a.extend({}, a.fn.bootstrapValidator.DEFAULT_OPTIONS, c), this.$invalidFields = a([]), this.$submitButton = null, this.$hiddenButton = null, this.STATUS_NOT_VALIDATED = "NOT_VALIDATED", this.STATUS_VALIDATING = "VALIDATING", this.STATUS_INVALID = "INVALID", this.STATUS_VALID = "VALID";
        var d = function() {
                for (var a = 3, b = document.createElement("div"), c = b.all || []; b.innerHTML = "<!--[if gt IE " + ++a + "]><br><![endif]-->", c[0];);
                return a > 4 ? a : !a
            }(),
            e = document.createElement("div");
        this._changeEvent = 9 !== d && "oninput" in e ? "input" : "keyup", this._submitIfValid = null, this._cacheFields = {}, this._init()
    };
    b.prototype = {
        constructor: b,
        _init: function() {
            var b = this,
                c = {
                    container: this.$form.attr("data-bv-container"),
                    events: {
                        formInit: this.$form.attr("data-bv-events-form-init"),
                        formError: this.$form.attr("data-bv-events-form-error"),
                        formSuccess: this.$form.attr("data-bv-events-form-success"),
                        fieldAdded: this.$form.attr("data-bv-events-field-added"),
                        fieldRemoved: this.$form.attr("data-bv-events-field-removed"),
                        fieldInit: this.$form.attr("data-bv-events-field-init"),
                        fieldError: this.$form.attr("data-bv-events-field-error"),
                        fieldSuccess: this.$form.attr("data-bv-events-field-success"),
                        fieldStatus: this.$form.attr("data-bv-events-field-status"),
                        validatorError: this.$form.attr("data-bv-events-validator-error"),
                        validatorSuccess: this.$form.attr("data-bv-events-validator-success")
                    },
                    excluded: this.$form.attr("data-bv-excluded"),
                    feedbackIcons: {
                        valid: this.$form.attr("data-bv-feedbackicons-valid"),
                        invalid: this.$form.attr("data-bv-feedbackicons-invalid"),
                        validating: this.$form.attr("data-bv-feedbackicons-validating")
                    },
                    group: this.$form.attr("data-bv-group"),
                    live: this.$form.attr("data-bv-live"),
                    message: this.$form.attr("data-bv-message"),
                    onError: this.$form.attr("data-bv-onerror"),
                    onSuccess: this.$form.attr("data-bv-onsuccess"),
                    submitButtons: this.$form.attr("data-bv-submitbuttons"),
                    threshold: this.$form.attr("data-bv-threshold"),
                    trigger: this.$form.attr("data-bv-trigger"),
                    verbose: this.$form.attr("data-bv-verbose"),
                    fields: {}
                };
            this.$form.attr("novalidate", "novalidate").addClass(this.options.elementClass).on("submit.bv", function(a) {
                a.preventDefault(), b.validate()
            }).on("click.bv", this.options.submitButtons, function() {
                b.$submitButton = a(this), b._submitIfValid = !0
            }).find("[name], [data-bv-field]").each(function() {
                var d = a(this),
                    e = d.attr("name") || d.attr("data-bv-field"),
                    f = b._parseOptions(d);
                f && (d.attr("data-bv-field", e), c.fields[e] = a.extend({}, f, c.fields[e]))
            }), this.options = a.extend(!0, this.options, c), this.$hiddenButton = a("<button/>").attr("type", "submit").prependTo(this.$form).addClass("bv-hidden-submit").css({
                display: "none",
                width: 0,
                height: 0
            }), this.$form.on("click.bv", '[type="submit"]', function(c) {
                if (!c.isDefaultPrevented()) {
                    var d = a(c.target),
                        e = d.is('[type="submit"]') ? d.eq(0) : d.parent('[type="submit"]').eq(0);
                    !b.options.submitButtons || e.is(b.options.submitButtons) || e.is(b.$hiddenButton) || b.$form.off("submit.bv").submit()
                }
            });
            for (var d in this.options.fields) this._initField(d);
            this.$form.trigger(a.Event(this.options.events.formInit), {
                bv: this,
                options: this.options
            }), this.options.onSuccess && this.$form.on(this.options.events.formSuccess, function(c) {
                a.fn.bootstrapValidator.helpers.call(b.options.onSuccess, [c])
            }), this.options.onError && this.$form.on(this.options.events.formError, function(c) {
                a.fn.bootstrapValidator.helpers.call(b.options.onError, [c])
            })
        },
        _parseOptions: function(b) {
            var c, d, e, f, g, h, i, j = b.attr("name") || b.attr("data-bv-field"),
                k = {};
            for (d in a.fn.bootstrapValidator.validators)
                if (c = a.fn.bootstrapValidator.validators[d], e = b.attr("data-bv-" + d.toLowerCase()) + "", i = "function" == typeof c.enableByHtml5 ? c.enableByHtml5(b) : null, i && "false" !== e || i !== !0 && ("" === e || "true" === e)) {
                    c.html5Attributes = a.extend({}, {
                        message: "message",
                        onerror: "onError",
                        onsuccess: "onSuccess"
                    }, c.html5Attributes), k[d] = a.extend({}, i === !0 ? {} : i, k[d]);
                    for (h in c.html5Attributes) f = c.html5Attributes[h], g = b.attr("data-bv-" + d.toLowerCase() + "-" + h), g && ("true" === g ? g = !0 : "false" === g && (g = !1), k[d][f] = g)
                }
            var l = {
                    container: b.attr("data-bv-container"),
                    excluded: b.attr("data-bv-excluded"),
                    feedbackIcons: b.attr("data-bv-feedbackicons"),
                    group: b.attr("data-bv-group"),
                    message: b.attr("data-bv-message"),
                    onError: b.attr("data-bv-onerror"),
                    onStatus: b.attr("data-bv-onstatus"),
                    onSuccess: b.attr("data-bv-onsuccess"),
                    selector: b.attr("data-bv-selector"),
                    threshold: b.attr("data-bv-threshold"),
                    trigger: b.attr("data-bv-trigger"),
                    verbose: b.attr("data-bv-verbose"),
                    validators: k
                },
                m = a.isEmptyObject(l),
                n = a.isEmptyObject(k);
            return !n || !m && this.options.fields && this.options.fields[j] ? (l.validators = k, l) : null
        },
        _initField: function(b) {
            var c = a([]);
            switch (typeof b) {
                case "object":
                    c = b, b = b.attr("data-bv-field");
                    break;
                case "string":
                    c = this.getFieldElements(b), c.attr("data-bv-field", b)
            }
            if (0 !== c.length && null !== this.options.fields[b] && null !== this.options.fields[b].validators) {
                var d;
                for (d in this.options.fields[b].validators) a.fn.bootstrapValidator.validators[d] || delete this.options.fields[b].validators[d];
                null === this.options.fields[b].enabled && (this.options.fields[b].enabled = !0);
                for (var e = this, f = c.length, g = c.attr("type"), h = 1 === f || "radio" === g || "checkbox" === g, i = "radio" === g || "checkbox" === g || "file" === g || "SELECT" === c.eq(0).get(0).tagName ? "change" : this._changeEvent, j = (this.options.fields[b].trigger || this.options.trigger || i).split(" "), k = a.map(j, function(a) {
                        return a + ".update.bv"
                    }).join(" "), l = 0; f > l; l++) {
                    var m = c.eq(l),
                        n = this.options.fields[b].group || this.options.group,
                        o = m.parents(n),
                        p = "function" == typeof(this.options.fields[b].container || this.options.container) ? (this.options.fields[b].container || this.options.container).call(this, m, this) : this.options.fields[b].container || this.options.container,
                        q = p && "tooltip" !== p && "popover" !== p ? a(p) : this._getMessageContainer(m, n);
                    p && "tooltip" !== p && "popover" !== p && q.addClass("has-error"), q.find('.help-block[data-bv-validator][data-bv-for="' + b + '"]').remove(), o.find('i[data-bv-icon-for="' + b + '"]').remove(), m.off(k).on(k, function() {
                        e.updateStatus(a(this), e.STATUS_NOT_VALIDATED)
                    }), m.data("bv.messages", q);
                    for (d in this.options.fields[b].validators) m.data("bv.result." + d, this.STATUS_NOT_VALIDATED), h && l !== f - 1 || a("<small/>").css("display", "none").addClass("help-block").attr("data-bv-validator", d).attr("data-bv-for", b).attr("data-bv-result", this.STATUS_NOT_VALIDATED).html(this._getMessage(b, d)).appendTo(q), "function" == typeof a.fn.bootstrapValidator.validators[d].init && a.fn.bootstrapValidator.validators[d].init(this, m, this.options.fields[b].validators[d]);
                    if (this.options.fields[b].feedbackIcons !== !1 && "false" !== this.options.fields[b].feedbackIcons && this.options.feedbackIcons && this.options.feedbackIcons.validating && this.options.feedbackIcons.invalid && this.options.feedbackIcons.valid && (!h || l === f - 1)) {
                        o.addClass("has-feedback");
                        var r = a("<i/>").css("display", "none").addClass("form-control-feedback").attr("data-bv-icon-for", b).insertAfter(m);
                        if ("checkbox" === g || "radio" === g) {
                            var s = m.parent();
                            s.hasClass(g) ? r.insertAfter(s) : s.parent().hasClass(g) && r.insertAfter(s.parent())
                        }
                        0 === o.find("label").length && r.addClass("bv-no-label"), 0 !== o.find(".input-group").length && r.addClass("bv-icon-input-group").insertAfter(o.find(".input-group").eq(0)), p && m.off("focus.bv").on("focus.bv", function() {
                            switch (p) {
                                case "tooltip":
                                    r.tooltip("show");
                                    break;
                                case "popover":
                                    r.popover("show")
                            }
                        }).off("blur.bv").on("blur.bv", function() {
                            switch (p) {
                                case "tooltip":
                                    r.tooltip("hide");
                                    break;
                                case "popover":
                                    r.popover("hide")
                            }
                        })
                    }
                }
                switch (c.on(this.options.events.fieldSuccess, function(b, c) {
                    var d = e.getOptions(c.field, null, "onSuccess");
                    d && a.fn.bootstrapValidator.helpers.call(d, [b, c])
                }).on(this.options.events.fieldError, function(b, c) {
                    var d = e.getOptions(c.field, null, "onError");
                    d && a.fn.bootstrapValidator.helpers.call(d, [b, c])
                }).on(this.options.events.fieldStatus, function(b, c) {
                    var d = e.getOptions(c.field, null, "onStatus");
                    d && a.fn.bootstrapValidator.helpers.call(d, [b, c])
                }).on(this.options.events.validatorError, function(b, c) {
                    var d = e.getOptions(c.field, c.validator, "onError");
                    d && a.fn.bootstrapValidator.helpers.call(d, [b, c])
                }).on(this.options.events.validatorSuccess, function(b, c) {
                    var d = e.getOptions(c.field, c.validator, "onSuccess");
                    d && a.fn.bootstrapValidator.helpers.call(d, [b, c])
                }), k = a.map(j, function(a) {
                    return a + ".live.bv"
                }).join(" "), this.options.live) {
                    case "submitted":
                        break;
                    case "disabled":
                        c.off(k);
                        break;
                    case "enabled":
                    default:
                        c.off(k).on(k, function() {
                            e._exceedThreshold(a(this)) && e.validateField(a(this))
                        })
                }
                c.trigger(a.Event(this.options.events.fieldInit), {
                    bv: this,
                    field: b,
                    element: c
                })
            }
        },
        _getMessage: function(b, c) {
            if (!(this.options.fields[b] && a.fn.bootstrapValidator.validators[c] && this.options.fields[b].validators && this.options.fields[b].validators[c])) return "";
            var d = this.options.fields[b].validators[c];
            switch (!0) {
                case !!d.message:
                    return d.message;
                case !!this.options.fields[b].message:
                    return this.options.fields[b].message;
                case !!a.fn.bootstrapValidator.i18n[c]:
                    return a.fn.bootstrapValidator.i18n[c]["default"];
                default:
                    return this.options.message
            }
        },
        _getMessageContainer: function(a, b) {
            var c = a.parent();
            if (c.is(b)) return c;
            var d = c.attr("class");
            if (!d) return this._getMessageContainer(c, b);
            d = d.split(" ");
            for (var e = d.length, f = 0; e > f; f++)
                if (/^col-(xs|sm|md|lg)-\d+$/.test(d[f]) || /^col-(xs|sm|md|lg)-offset-\d+$/.test(d[f])) return c;
            return this._getMessageContainer(c, b)
        },
        _submit: function() {
            var b = this.isValid(),
                c = b ? this.options.events.formSuccess : this.options.events.formError,
                d = a.Event(c);
            this.$form.trigger(d), this.$submitButton && (b ? this._onSuccess(d) : this._onError(d))
        },
        _isExcluded: function(b) {
            var c = b.attr("data-bv-excluded"),
                d = b.attr("data-bv-field") || b.attr("name");
            switch (!0) {
                case !!d && this.options.fields && this.options.fields[d] && ("true" === this.options.fields[d].excluded || this.options.fields[d].excluded === !0):
                case "true" === c:
                case "" === c:
                    return !0;
                case !!d && this.options.fields && this.options.fields[d] && ("false" === this.options.fields[d].excluded || this.options.fields[d].excluded === !1):
                case "false" === c:
                    return !1;
                default:
                    if (this.options.excluded) {
                        "string" == typeof this.options.excluded && (this.options.excluded = a.map(this.options.excluded.split(","), function(b) {
                            return a.trim(b)
                        }));
                        for (var e = this.options.excluded.length, f = 0; e > f; f++)
                            if ("string" == typeof this.options.excluded[f] && b.is(this.options.excluded[f]) || "function" == typeof this.options.excluded[f] && this.options.excluded[f].call(this, b, this) === !0) return !0
                    }
                    return !1
            }
        },
        _exceedThreshold: function(b) {
            var c = b.attr("data-bv-field"),
                d = this.options.fields[c].threshold || this.options.threshold;
            if (!d) return !0;
            var e = -1 !== a.inArray(b.attr("type"), ["button", "checkbox", "file", "hidden", "image", "radio", "reset", "submit"]);
            return e || b.val().length >= d
        },
        _onError: function(b) {
            if (!b.isDefaultPrevented()) {
                if ("submitted" === this.options.live) {
                    this.options.live = "enabled";
                    var c = this;
                    for (var d in this.options.fields) ! function(b) {
                        var e = c.getFieldElements(b);
                        if (e.length) {
                            var f = a(e[0]).attr("type"),
                                g = "radio" === f || "checkbox" === f || "file" === f || "SELECT" === a(e[0]).get(0).tagName ? "change" : c._changeEvent,
                                h = c.options.fields[d].trigger || c.options.trigger || g,
                                i = a.map(h.split(" "), function(a) {
                                    return a + ".live.bv"
                                }).join(" ");
                            e.off(i).on(i, function() {
                                c._exceedThreshold(a(this)) && c.validateField(a(this))
                            })
                        }
                    }(d)
                }
                var e = this.$invalidFields.eq(0);
                if (e) {
                    var f, g = e.parents(".tab-pane");
                    g && (f = g.attr("id")) && a('a[href="#' + f + '"][data-toggle="tab"]').tab("show"), e.focus()
                }
            }
        },
        _onSuccess: function(a) {
            a.isDefaultPrevented() || this.disableSubmitButtons(!0).defaultSubmit()
        },
        _onFieldValidated: function(b, c) {
            var d = b.attr("data-bv-field"),
                e = this.options.fields[d].validators,
                f = {},
                g = 0,
                h = {
                    bv: this,
                    field: d,
                    element: b,
                    validator: c,
                    result: b.data("bv.response." + c)
                };
            if (c) switch (b.data("bv.result." + c)) {
                case this.STATUS_INVALID:
                    b.trigger(a.Event(this.options.events.validatorError), h);
                    break;
                case this.STATUS_VALID:
                    b.trigger(a.Event(this.options.events.validatorSuccess), h)
            }
            f[this.STATUS_NOT_VALIDATED] = 0, f[this.STATUS_VALIDATING] = 0, f[this.STATUS_INVALID] = 0, f[this.STATUS_VALID] = 0;
            for (var i in e)
                if (e[i].enabled !== !1) {
                    g++;
                    var j = b.data("bv.result." + i);
                    j && f[j]++
                }
            f[this.STATUS_VALID] === g ? (this.$invalidFields = this.$invalidFields.not(b), b.trigger(a.Event(this.options.events.fieldSuccess), h)) : 0 === f[this.STATUS_NOT_VALIDATED] && 0 === f[this.STATUS_VALIDATING] && f[this.STATUS_INVALID] > 0 && (this.$invalidFields = this.$invalidFields.add(b), b.trigger(a.Event(this.options.events.fieldError), h))
        },
        getFieldElements: function(b) {
            return this._cacheFields[b] || (this._cacheFields[b] = this.options.fields[b] && this.options.fields[b].selector ? a(this.options.fields[b].selector) : this.$form.find('[name="' + b + '"]')), this._cacheFields[b]
        },
        getOptions: function(a, b, c) {
            if (!a) return this.options;
            if ("object" == typeof a && (a = a.attr("data-bv-field")), !this.options.fields[a]) return null;
            var d = this.options.fields[a];
            return b ? d.validators && d.validators[b] ? c ? d.validators[b][c] : d.validators[b] : null : c ? d[c] : d
        },
        disableSubmitButtons: function(a) {
            return a ? "disabled" !== this.options.live && this.$form.find(this.options.submitButtons).attr("disabled", "disabled") : this.$form.find(this.options.submitButtons).removeAttr("disabled"), this
        },
        validate: function() {
            if (!this.options.fields) return this;
            this.disableSubmitButtons(!0);
            for (var a in this.options.fields) this.validateField(a);
            return this._submit(), this
        },
        validateField: function(b) {
            var c = a([]);
            switch (typeof b) {
                case "object":
                    c = b, b = b.attr("data-bv-field");
                    break;
                case "string":
                    c = this.getFieldElements(b)
            }
            if (0 === c.length || this.options.fields[b] && this.options.fields[b].enabled === !1) return this;
            for (var d, e, f = this, g = c.attr("type"), h = "radio" === g || "checkbox" === g ? 1 : c.length, i = "radio" === g || "checkbox" === g, j = this.options.fields[b].validators, k = "true" === this.options.fields[b].verbose || this.options.fields[b].verbose === !0 || "true" === this.options.verbose || this.options.verbose === !0, l = 0; h > l; l++) {
                var m = c.eq(l);
                if (!this._isExcluded(m)) {
                    var n = !1;
                    for (d in j) {
                        if (m.data("bv.dfs." + d) && m.data("bv.dfs." + d).reject(), n) break;
                        var o = m.data("bv.result." + d);
                        if (o !== this.STATUS_VALID && o !== this.STATUS_INVALID)
                            if (j[d].enabled !== !1) {
                                if (m.data("bv.result." + d, this.STATUS_VALIDATING), e = a.fn.bootstrapValidator.validators[d].validate(this, m, j[d]), "object" == typeof e && e.resolve) this.updateStatus(i ? b : m, this.STATUS_VALIDATING, d), m.data("bv.dfs." + d, e), e.done(function(a, b, c) {
                                    a.removeData("bv.dfs." + b).data("bv.response." + b, c), c.message && f.updateMessage(a, b, c.message), f.updateStatus(i ? a.attr("data-bv-field") : a, c.valid ? f.STATUS_VALID : f.STATUS_INVALID, b), c.valid && f._submitIfValid === !0 ? f._submit() : c.valid || k || (n = !0)
                                });
                                else if ("object" == typeof e && void 0 !== e.valid && void 0 !== e.message) {
                                    if (m.data("bv.response." + d, e), this.updateMessage(i ? b : m, d, e.message), this.updateStatus(i ? b : m, e.valid ? this.STATUS_VALID : this.STATUS_INVALID, d), !e.valid && !k) break
                                } else if ("boolean" == typeof e && (m.data("bv.response." + d, e), this.updateStatus(i ? b : m, e ? this.STATUS_VALID : this.STATUS_INVALID, d), !e && !k)) break
                            } else this.updateStatus(i ? b : m, this.STATUS_VALID, d);
                        else this._onFieldValidated(m, d)
                    }
                }
            }
            return this
        },
        updateMessage: function(b, c, d) {
            var e = a([]);
            switch (typeof b) {
                case "object":
                    e = b, b = b.attr("data-bv-field");
                    break;
                case "string":
                    e = this.getFieldElements(b)
            }
            e.each(function() {
                a(this).data("bv.messages").find('.help-block[data-bv-validator="' + c + '"][data-bv-for="' + b + '"]').html(d)
            })
        },
        updateStatus: function(b, c, d) {
            var e = a([]);
            switch (typeof b) {
                case "object":
                    e = b, b = b.attr("data-bv-field");
                    break;
                case "string":
                    e = this.getFieldElements(b)
            }
            c === this.STATUS_NOT_VALIDATED && (this._submitIfValid = !1);
            for (var f = this, g = e.attr("type"), h = this.options.fields[b].group || this.options.group, i = "radio" === g || "checkbox" === g ? 1 : e.length, j = 0; i > j; j++) {
                var k = e.eq(j);
                if (!this._isExcluded(k)) {
                    var l = k.parents(h),
                        m = k.data("bv.messages"),
                        n = m.find('.help-block[data-bv-validator][data-bv-for="' + b + '"]'),
                        o = d ? n.filter('[data-bv-validator="' + d + '"]') : n,
                        p = l.find('.form-control-feedback[data-bv-icon-for="' + b + '"]'),
                        q = "function" == typeof(this.options.fields[b].container || this.options.container) ? (this.options.fields[b].container || this.options.container).call(this, k, this) : this.options.fields[b].container || this.options.container,
                        r = null;
                    if (d) k.data("bv.result." + d, c);
                    else
                        for (var s in this.options.fields[b].validators) k.data("bv.result." + s, c);
                    o.attr("data-bv-result", c);
                    var t, u, v = k.parents(".tab-pane");
                    switch (v && (t = v.attr("id")) && (u = a('a[href="#' + t + '"][data-toggle="tab"]').parent()), c) {
                        case this.STATUS_VALIDATING:
                            r = null, this.disableSubmitButtons(!0), l.removeClass("has-success").removeClass("has-error"), p && p.removeClass(this.options.feedbackIcons.valid).removeClass(this.options.feedbackIcons.invalid).addClass(this.options.feedbackIcons.validating).show(), u && u.removeClass("bv-tab-success").removeClass("bv-tab-error");
                            break;
                        case this.STATUS_INVALID:
                            r = !1, this.disableSubmitButtons(!0), l.removeClass("has-success").addClass("has-error"), p && p.removeClass(this.options.feedbackIcons.valid).removeClass(this.options.feedbackIcons.validating).addClass(this.options.feedbackIcons.invalid).show(), u && u.removeClass("bv-tab-success").addClass("bv-tab-error");
                            break;
                        case this.STATUS_VALID:
                            r = 0 === n.filter('[data-bv-result="' + this.STATUS_NOT_VALIDATED + '"]').length ? n.filter('[data-bv-result="' + this.STATUS_VALID + '"]').length === n.length : null, null !== r && (this.disableSubmitButtons(this.$submitButton ? !this.isValid() : !r), p && p.removeClass(this.options.feedbackIcons.invalid).removeClass(this.options.feedbackIcons.validating).removeClass(this.options.feedbackIcons.valid).addClass(r ? this.options.feedbackIcons.valid : this.options.feedbackIcons.invalid).show()), l.removeClass("has-error has-success").addClass(this.isValidContainer(l) ? "has-success" : "has-error"), u && u.removeClass("bv-tab-success").removeClass("bv-tab-error").addClass(this.isValidContainer(v) ? "bv-tab-success" : "bv-tab-error");
                            break;
                        case this.STATUS_NOT_VALIDATED:
                        default:
                            r = null, this.disableSubmitButtons(!1), l.removeClass("has-success").removeClass("has-error"), p && p.removeClass(this.options.feedbackIcons.valid).removeClass(this.options.feedbackIcons.invalid).removeClass(this.options.feedbackIcons.validating).hide(), u && u.removeClass("bv-tab-success").removeClass("bv-tab-error")
                    }
                    switch (!0) {
                        case p && "tooltip" === q:
                            r === !1 ? p.css("cursor", "pointer").tooltip("destroy").tooltip({
                                container: "body",
                                html: !0,
                                placement: "top",
                                title: n.filter('[data-bv-result="' + f.STATUS_INVALID + '"]').eq(0).html()
                            }) : p.tooltip("hide");
                            break;
                        case p && "popover" === q:
                            r === !1 ? p.css("cursor", "pointer").popover("destroy").popover({
                                container: "body",
                                content: n.filter('[data-bv-result="' + f.STATUS_INVALID + '"]').eq(0).html(),
                                html: !0,
                                placement: "top",
                                trigger: "hover click"
                            }) : p.popover("hide");
                            break;
                        default:
                            c === this.STATUS_INVALID ? o.show() : o.hide()
                    }
                    k.trigger(a.Event(this.options.events.fieldStatus), {
                        bv: this,
                        field: b,
                        element: k,
                        status: c
                    }), this._onFieldValidated(k, d)
                }
            }
            return this
        },
        isValid: function() {
            for (var a in this.options.fields)
                if (!this.isValidField(a)) return !1;
            return !0
        },
        isValidField: function(b) {
            var c = a([]);
            switch (typeof b) {
                case "object":
                    c = b, b = b.attr("data-bv-field");
                    break;
                case "string":
                    c = this.getFieldElements(b)
            }
            if (0 === c.length || null === this.options.fields[b] || this.options.fields[b].enabled === !1) return !0;
            for (var d, e, f, g = c.attr("type"), h = "radio" === g || "checkbox" === g ? 1 : c.length, i = 0; h > i; i++)
                if (d = c.eq(i), !this._isExcluded(d))
                    for (e in this.options.fields[b].validators)
                        if (this.options.fields[b].validators[e].enabled !== !1 && (f = d.data("bv.result." + e), f !== this.STATUS_VALID)) return !1;
            return !0
        },
        isValidContainer: function(b) {
            var c = this,
                d = {},
                e = "string" == typeof b ? a(b) : b;
            if (0 === e.length) return !0;
            e.find("[data-bv-field]").each(function() {
                var b = a(this),
                    e = b.attr("data-bv-field");
                c._isExcluded(b) || d[e] || (d[e] = b)
            });
            for (var f in d) {
                var g = d[f];
                if (g.data("bv.messages").find('.help-block[data-bv-validator][data-bv-for="' + f + '"]').filter('[data-bv-result="' + this.STATUS_INVALID + '"]').length > 0) return !1
            }
            return !0
        },
        defaultSubmit: function() {
            this.$submitButton && a("<input/>").attr("type", "hidden").attr("data-bv-submit-hidden", "").attr("name", this.$submitButton.attr("name")).val(this.$submitButton.val()).appendTo(this.$form), this.$form.off("submit.bv").submit()
        },
        getInvalidFields: function() {
            return this.$invalidFields
        },
        getSubmitButton: function() {
            return this.$submitButton
        },
        getMessages: function(b, c) {
            var d = this,
                e = [],
                f = a([]);
            switch (!0) {
                case b && "object" == typeof b:
                    f = b;
                    break;
                case b && "string" == typeof b:
                    var g = this.getFieldElements(b);
                    if (g.length > 0) {
                        var h = g.attr("type");
                        f = "radio" === h || "checkbox" === h ? g.eq(0) : g
                    }
                    break;
                default:
                    f = this.$invalidFields
            }
            var i = c ? '[data-bv-validator="' + c + '"]' : "";
            return f.each(function() {
                e = e.concat(a(this).data("bv.messages").find('.help-block[data-bv-for="' + a(this).attr("data-bv-field") + '"][data-bv-result="' + d.STATUS_INVALID + '"]' + i).map(function() {
                    var b = a(this).attr("data-bv-validator"),
                        c = a(this).attr("data-bv-for");
                    return d.options.fields[c].validators[b].enabled === !1 ? "" : a(this).html()
                }).get())
            }), e
        },
        updateOption: function(a, b, c, d) {
            return "object" == typeof a && (a = a.attr("data-bv-field")), this.options.fields[a] && this.options.fields[a].validators[b] && (this.options.fields[a].validators[b][c] = d, this.updateStatus(a, this.STATUS_NOT_VALIDATED, b)), this
        },
        addField: function(b, c) {
            var d = a([]);
            switch (typeof b) {
                case "object":
                    d = b, b = b.attr("data-bv-field") || b.attr("name");
                    break;
                case "string":
                    delete this._cacheFields[b], d = this.getFieldElements(b)
            }
            d.attr("data-bv-field", b);
            for (var e = d.attr("type"), f = "radio" === e || "checkbox" === e ? 1 : d.length, g = 0; f > g; g++) {
                var h = d.eq(g),
                    i = this._parseOptions(h);
                i = null === i ? c : a.extend(!0, c, i), this.options.fields[b] = a.extend(!0, this.options.fields[b], i), this._cacheFields[b] = this._cacheFields[b] ? this._cacheFields[b].add(h) : h, this._initField("checkbox" === e || "radio" === e ? b : h)
            }
            return this.disableSubmitButtons(!1), this.$form.trigger(a.Event(this.options.events.fieldAdded), {
                field: b,
                element: d,
                options: this.options.fields[b]
            }), this
        },
        removeField: function(b) {
            var c = a([]);
            switch (typeof b) {
                case "object":
                    c = b, b = b.attr("data-bv-field") || b.attr("name"), c.attr("data-bv-field", b);
                    break;
                case "string":
                    c = this.getFieldElements(b)
            }
            if (0 === c.length) return this;
            for (var d = c.attr("type"), e = "radio" === d || "checkbox" === d ? 1 : c.length, f = 0; e > f; f++) {
                var g = c.eq(f);
                this.$invalidFields = this.$invalidFields.not(g), this._cacheFields[b] = this._cacheFields[b].not(g)
            }
            return this._cacheFields[b] && 0 !== this._cacheFields[b].length || delete this.options.fields[b], ("checkbox" === d || "radio" === d) && this._initField(b), this.disableSubmitButtons(!1), this.$form.trigger(a.Event(this.options.events.fieldRemoved), {
                field: b,
                element: c
            }), this
        },
        resetField: function(b, c) {
            var d = a([]);
            switch (typeof b) {
                case "object":
                    d = b, b = b.attr("data-bv-field");
                    break;
                case "string":
                    d = this.getFieldElements(b)
            }
            var e = d.length;
            if (this.options.fields[b])
                for (var f = 0; e > f; f++)
                    for (var g in this.options.fields[b].validators) d.eq(f).removeData("bv.dfs." + g);
            if (this.updateStatus(b, this.STATUS_NOT_VALIDATED), c) {
                var h = d.attr("type");
                "radio" === h || "checkbox" === h ? d.removeAttr("checked").removeAttr("selected") : d.val("")
            }
            return this
        },
        resetForm: function(b) {
            for (var c in this.options.fields) this.resetField(c, b);
            return this.$invalidFields = a([]), this.$submitButton = null, this.disableSubmitButtons(!1), this
        },
        revalidateField: function(a) {
            return this.updateStatus(a, this.STATUS_NOT_VALIDATED).validateField(a), this
        },
        enableFieldValidators: function(a, b, c) {
            var d = this.options.fields[a].validators;
            if (c && d && d[c] && d[c].enabled !== b) this.options.fields[a].validators[c].enabled = b, this.updateStatus(a, this.STATUS_NOT_VALIDATED, c);
            else if (!c && this.options.fields[a].enabled !== b) {
                this.options.fields[a].enabled = b;
                for (var e in d) this.enableFieldValidators(a, b, e)
            }
            return this
        },
        getDynamicOption: function(b, c) {
            var d = "string" == typeof b ? this.getFieldElements(b) : b,
                e = d.val();
            if ("function" == typeof c) return a.fn.bootstrapValidator.helpers.call(c, [e, this, d]);
            if ("string" == typeof c) {
                var f = this.getFieldElements(c);
                return f.length ? f.val() : a.fn.bootstrapValidator.helpers.call(c, [e, this, d]) || c
            }
            return null
        },
        destroy: function() {
            var b, c, d, e, f, g;
            for (b in this.options.fields) {
                c = this.getFieldElements(b), g = this.options.fields[b].group || this.options.group;
                for (var h = 0; h < c.length; h++) {
                    if (d = c.eq(h), d.data("bv.messages").find('.help-block[data-bv-validator][data-bv-for="' + b + '"]').remove().end().end().removeData("bv.messages").parents(g).removeClass("has-feedback has-error has-success").end().off(".bv").removeAttr("data-bv-field"), f = d.parents(g).find('i[data-bv-icon-for="' + b + '"]')) {
                        var i = "function" == typeof(this.options.fields[b].container || this.options.container) ? (this.options.fields[b].container || this.options.container).call(this, d, this) : this.options.fields[b].container || this.options.container;
                        switch (i) {
                            case "tooltip":
                                f.tooltip("destroy").remove();
                                break;
                            case "popover":
                                f.popover("destroy").remove();
                                break;
                            default:
                                f.remove()
                        }
                    }
                    for (e in this.options.fields[b].validators) d.data("bv.dfs." + e) && d.data("bv.dfs." + e).reject(), d.removeData("bv.result." + e).removeData("bv.response." + e).removeData("bv.dfs." + e), "function" == typeof a.fn.bootstrapValidator.validators[e].destroy && a.fn.bootstrapValidator.validators[e].destroy(this, d, this.options.fields[b].validators[e])
                }
            }
            this.disableSubmitButtons(!1), this.$hiddenButton.remove(), this.$form.removeClass(this.options.elementClass).off(".bv").removeData("bootstrapValidator").find("[data-bv-submit-hidden]").remove().end().find('[type="submit"]').off("click.bv")
        }
    }, a.fn.bootstrapValidator = function(c) {
        var d = arguments;
        return this.each(function() {
            var e = a(this),
                f = e.data("bootstrapValidator"),
                g = "object" == typeof c && c;
            f || (f = new b(this, g), e.data("bootstrapValidator", f)), "string" == typeof c && f[c].apply(f, Array.prototype.slice.call(d, 1))
        })
    }, a.fn.bootstrapValidator.DEFAULT_OPTIONS = {
        elementClass: "bv-form",
        message: "This value is not valid",
        group: ".form-group",
        container: null,
        threshold: null,
        excluded: [":disabled", ":hidden", ":not(:visible)"],
        feedbackIcons: {
            valid: null,
            invalid: null,
            validating: null
        },
        submitButtons: '[type="submit"]',
        live: "enabled",
        fields: null,
        events: {
            formInit: "init.form.bv",
            formError: "error.form.bv",
            formSuccess: "success.form.bv",
            fieldAdded: "added.field.bv",
            fieldRemoved: "removed.field.bv",
            fieldInit: "init.field.bv",
            fieldError: "error.field.bv",
            fieldSuccess: "success.field.bv",
            fieldStatus: "status.field.bv",
            validatorError: "error.validator.bv",
            validatorSuccess: "success.validator.bv"
        },
        verbose: !0
    }, a.fn.bootstrapValidator.validators = {}, a.fn.bootstrapValidator.i18n = {}, a.fn.bootstrapValidator.Constructor = b, a.fn.bootstrapValidator.helpers = {
        call: function(a, b) {
            if ("function" == typeof a) return a.apply(this, b);
            if ("string" == typeof a) {
                "()" === a.substring(a.length - 2) && (a = a.substring(0, a.length - 2));
                for (var c = a.split("."), d = c.pop(), e = window, f = 0; f < c.length; f++) e = e[c[f]];
                return "undefined" == typeof e[d] ? null : e[d].apply(this, b)
            }
        },
        format: function(b, c) {
            a.isArray(c) || (c = [c]);
            for (var d in c) b = b.replace("%s", c[d]);
            return b
        },
        date: function(a, b, c, d) {
            if (isNaN(a) || isNaN(b) || isNaN(c)) return !1;
            if (c.length > 2 || b.length > 2 || a.length > 4) return !1;
            if (c = parseInt(c, 10), b = parseInt(b, 10), a = parseInt(a, 10), 1e3 > a || a > 9999 || 0 >= b || b > 12) return !1;
            var e = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31];
            if ((a % 400 === 0 || a % 100 !== 0 && a % 4 === 0) && (e[1] = 29), 0 >= c || c > e[b - 1]) return !1;
            if (d === !0) {
                var f = new Date,
                    g = f.getFullYear(),
                    h = f.getMonth(),
                    i = f.getDate();
                return g > a || a === g && h > b - 1 || a === g && b - 1 === h && i > c
            }
            return !0
        },
        luhn: function(a) {
            for (var b = a.length, c = 0, d = [
                    [0, 1, 2, 3, 4, 5, 6, 7, 8, 9],
                    [0, 2, 4, 6, 8, 1, 3, 5, 7, 9]
                ], e = 0; b--;) e += d[c][parseInt(a.charAt(b), 10)], c ^= 1;
            return e % 10 === 0 && e > 0
        },
        mod11And10: function(a) {
            for (var b = 5, c = a.length, d = 0; c > d; d++) b = (2 * (b || 10) % 11 + parseInt(a.charAt(d), 10)) % 10;
            return 1 === b
        },
        mod37And36: function(a, b) {
            b = b || "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            for (var c = b.length, d = a.length, e = Math.floor(c / 2), f = 0; d > f; f++) e = (2 * (e || c) % (c + 1) + b.indexOf(a.charAt(f))) % c;
            return 1 === e
        }
    }
}(window.jQuery),
function(a) {
    a.fn.bootstrapValidator.i18n.base64 = a.extend(a.fn.bootstrapValidator.i18n.base64 || {}, {
        "default": "Please enter a valid base 64 encoded"
    }), a.fn.bootstrapValidator.validators.base64 = {
        validate: function(a, b) {
            var c = b.val();
            return "" === c ? !0 : /^(?:[A-Za-z0-9+/]{4})*(?:[A-Za-z0-9+/]{2}==|[A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{4})$/.test(c)
        }
    }
}(window.jQuery),
function(a) {
    a.fn.bootstrapValidator.i18n.between = a.extend(a.fn.bootstrapValidator.i18n.between || {}, {
        "default": "Please enter a value between %s and %s",
        notInclusive: "Please enter a value between %s and %s strictly"
    }), a.fn.bootstrapValidator.validators.between = {
        html5Attributes: {
            message: "message",
            min: "min",
            max: "max",
            inclusive: "inclusive"
        },
        enableByHtml5: function(a) {
            return "range" === a.attr("type") ? {
                min: a.attr("min"),
                max: a.attr("max")
            } : !1
        },
        validate: function(b, c, d) {
            var e = c.val();
            if ("" === e) return !0;
            if (!a.isNumeric(e)) return !1;
            var f = a.isNumeric(d.min) ? d.min : b.getDynamicOption(c, d.min),
                g = a.isNumeric(d.max) ? d.max : b.getDynamicOption(c, d.max);
            return e = parseFloat(e), d.inclusive === !0 || void 0 === d.inclusive ? {
                valid: e >= f && g >= e,
                message: a.fn.bootstrapValidator.helpers.format(d.message || a.fn.bootstrapValidator.i18n.between["default"], [f, g])
            } : {
                valid: e > f && g > e,
                message: a.fn.bootstrapValidator.helpers.format(d.message || a.fn.bootstrapValidator.i18n.between.notInclusive, [f, g])
            }
        }
    }
}(window.jQuery),
function(a) {
    a.fn.bootstrapValidator.validators.blank = {
        validate: function() {
            return !0
        }
    }
}(window.jQuery),
function(a) {
    a.fn.bootstrapValidator.i18n.callback = a.extend(a.fn.bootstrapValidator.i18n.callback || {}, {
        "default": "Please enter a valid value"
    }), a.fn.bootstrapValidator.validators.callback = {
        html5Attributes: {
            message: "message",
            callback: "callback"
        },
        validate: function(b, c, d) {
            var e = c.val(),
                f = new a.Deferred,
                g = {
                    valid: !0
                };
            if (d.callback) {
                var h = a.fn.bootstrapValidator.helpers.call(d.callback, [e, b, c]);
                g = "boolean" == typeof h ? {
                    valid: h
                } : h
            }
            return f.resolve(c, "callback", g), f
        }
    }
}(window.jQuery),
function(a) {
    a.fn.bootstrapValidator.i18n.choice = a.extend(a.fn.bootstrapValidator.i18n.choice || {}, {
        "default": "Please enter a valid value",
        less: "Please choose %s options at minimum",
        more: "Please choose %s options at maximum",
        between: "Please choose %s - %s options"
    }), a.fn.bootstrapValidator.validators.choice = {
        html5Attributes: {
            message: "message",
            min: "min",
            max: "max"
        },
        validate: function(b, c, d) {
            var e = c.is("select") ? b.getFieldElements(c.attr("data-bv-field")).find("option").filter(":selected").length : b.getFieldElements(c.attr("data-bv-field")).filter(":checked").length,
                f = d.min ? a.isNumeric(d.min) ? d.min : b.getDynamicOption(c, d.min) : null,
                g = d.max ? a.isNumeric(d.max) ? d.max : b.getDynamicOption(c, d.max) : null,
                h = !0,
                i = d.message || a.fn.bootstrapValidator.i18n.choice["default"];
            switch ((f && e < parseInt(f, 10) || g && e > parseInt(g, 10)) && (h = !1), !0) {
                case !!f && !!g:
                    i = a.fn.bootstrapValidator.helpers.format(d.message || a.fn.bootstrapValidator.i18n.choice.between, [parseInt(f, 10), parseInt(g, 10)]);
                    break;
                case !!f:
                    i = a.fn.bootstrapValidator.helpers.format(d.message || a.fn.bootstrapValidator.i18n.choice.less, parseInt(f, 10));
                    break;
                case !!g:
                    i = a.fn.bootstrapValidator.helpers.format(d.message || a.fn.bootstrapValidator.i18n.choice.more, parseInt(g, 10))
            }
            return {
                valid: h,
                message: i
            }
        }
    }
}(window.jQuery),
function(a) {
    a.fn.bootstrapValidator.i18n.date = a.extend(a.fn.bootstrapValidator.i18n.date || {}, {
        "default": "Please enter a valid date"
    }), a.fn.bootstrapValidator.validators.date = {
        html5Attributes: {
            message: "message",
            format: "format",
            separator: "separator"
        },
        validate: function(b, c, d) {
            var e = c.val();
            if ("" === e) return !0;
            d.format = d.format || "MM/DD/YYYY", "date" === c.attr("type") && (d.format = "YYYY-MM-DD");
            var f = d.format.split(" "),
                g = f[0],
                h = f.length > 1 ? f[1] : null,
                i = f.length > 2 ? f[2] : null,
                j = e.split(" "),
                k = j[0],
                l = j.length > 1 ? j[1] : null;
            if (f.length !== j.length) return !1;
            var m = d.separator;
            if (m || (m = -1 !== k.indexOf("/") ? "/" : -1 !== k.indexOf("-") ? "-" : null), null === m || -1 === k.indexOf(m)) return !1;
            if (k = k.split(m), g = g.split(m), k.length !== g.length) return !1;
            var n = k[a.inArray("YYYY", g)],
                o = k[a.inArray("MM", g)],
                p = k[a.inArray("DD", g)];
            if (!n || !o || !p || 4 !== n.length) return !1;
            var q = null,
                r = null,
                s = null;
            if (h) {
                if (h = h.split(":"), l = l.split(":"), h.length !== l.length) return !1;
                if (r = l.length > 0 ? l[0] : null, q = l.length > 1 ? l[1] : null, s = l.length > 2 ? l[2] : null) {
                    if (isNaN(s) || s.length > 2) return !1;
                    if (s = parseInt(s, 10), 0 > s || s > 60) return !1
                }
                if (r) {
                    if (isNaN(r) || r.length > 2) return !1;
                    if (r = parseInt(r, 10), 0 > r || r >= 24 || i && r > 12) return !1
                }
                if (q) {
                    if (isNaN(q) || q.length > 2) return !1;
                    if (q = parseInt(q, 10), 0 > q || q > 59) return !1
                }
            }
            return a.fn.bootstrapValidator.helpers.date(n, o, p)
        }
    }
}(window.jQuery),
function(a) {
    a.fn.bootstrapValidator.i18n.different = a.extend(a.fn.bootstrapValidator.i18n.different || {}, {
        "default": "Please enter a different value"
    }), a.fn.bootstrapValidator.validators.different = {
        html5Attributes: {
            message: "message",
            field: "field"
        },
        validate: function(a, b, c) {
            var d = b.val();
            if ("" === d) return !0;
            for (var e = c.field.split(","), f = !0, g = 0; g < e.length; g++) {
                var h = a.getFieldElements(e[g]);
                if (null != h && 0 !== h.length) {
                    var i = h.val();
                    d === i ? f = !1 : "" !== i && a.updateStatus(h, a.STATUS_VALID, "different")
                }
            }
            return f
        }
    }
}(window.jQuery),
function(a) {
    a.fn.bootstrapValidator.i18n.digits = a.extend(a.fn.bootstrapValidator.i18n.digits || {}, {
        "default": "Please enter only digits"
    }), a.fn.bootstrapValidator.validators.digits = {
        validate: function(a, b) {
            var c = b.val();
            return "" === c ? !0 : /^\d+$/.test(c)
        }
    }
}(window.jQuery),
function(a) {
    a.fn.bootstrapValidator.i18n.emailAddress = a.extend(a.fn.bootstrapValidator.i18n.emailAddress || {}, {
        "default": "정확한 이메일을 입력하세요"
    }), a.fn.bootstrapValidator.validators.emailAddress = {
        html5Attributes: {
            message: "message",
            multiple: "multiple",
            separator: "separator"
        },
        enableByHtml5: function(a) {
            return "email" === a.attr("type")
        },
        validate: function(a, b, c) {
            var d = b.val();
            if ("" === d) return !0;
            var e = /([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/,
                f = c.multiple === !0 || "true" === c.multiple;
            if (f) {
                for (var g = c.separator || /[,;]/, h = this._splitEmailAddresses(d, g), i = 0; i < h.length; i++)
                    if (!e.test(h[i])) return !1;
                return !0
            }
            return e.test(d)
        },
        _splitEmailAddresses: function(a, b) {
            for (var c = a.split(/"/), d = c.length, e = [], f = "", g = 0; d > g; g++)
                if (g % 2 === 0) {
                    var h = c[g].split(b),
                        i = h.length;
                    if (1 === i) f += h[0];
                    else {
                        e.push(f + h[0]);
                        for (var j = 1; i - 1 > j; j++) e.push(h[j]);
                        f = h[i - 1]
                    }
                } else f += '"' + c[g], d - 1 > g && (f += '"');
            return e.push(f), e
        }
    }
}(window.jQuery),
function(a) {
    a.fn.bootstrapValidator.i18n.file = a.extend(a.fn.bootstrapValidator.i18n.file || {}, {
        "default": "Please choose a valid file"
    }), a.fn.bootstrapValidator.validators.file = {
        html5Attributes: {
            extension: "extension",
            maxsize: "maxSize",
            minsize: "minSize",
            message: "message",
            type: "type"
        },
        validate: function(b, c, d) {
            var e = c.val();
            if ("" === e) return !0;
            var f, g = d.extension ? d.extension.toLowerCase().split(",") : null,
                h = d.type ? d.type.toLowerCase().split(",") : null,
                i = window.File && window.FileList && window.FileReader;
            if (i)
                for (var j = c.get(0).files, k = j.length, l = 0; k > l; l++) {
                    if (d.minSize && j[l].size < parseInt(d.minSize, 10)) return !1;
                    if (d.maxSize && j[l].size > parseInt(d.maxSize, 10)) return !1;
                    if (f = j[l].name.substr(j[l].name.lastIndexOf(".") + 1), g && -1 === a.inArray(f.toLowerCase(), g)) return !1;
                    if (j[l].type && h && -1 === a.inArray(j[l].type.toLowerCase(), h)) return !1
                } else if (f = e.substr(e.lastIndexOf(".") + 1), g && -1 === a.inArray(f.toLowerCase(), g)) return !1;
            return !0
        }
    }
}(window.jQuery),
function(a) {
    a.fn.bootstrapValidator.i18n.greaterThan = a.extend(a.fn.bootstrapValidator.i18n.greaterThan || {}, {
        "default": "Please enter a value greater than or equal to %s",
        notInclusive: "Please enter a value greater than %s"
    }), a.fn.bootstrapValidator.validators.greaterThan = {
        html5Attributes: {
            message: "message",
            value: "value",
            inclusive: "inclusive"
        },
        enableByHtml5: function(a) {
            var b = a.attr("type"),
                c = a.attr("min");
            return c && "date" !== b ? {
                value: c
            } : !1
        },
        validate: function(b, c, d) {
            var e = c.val();
            if ("" === e) return !0;
            if (!a.isNumeric(e)) return !1;
            var f = a.isNumeric(d.value) ? d.value : b.getDynamicOption(c, d.value);
            return e = parseFloat(e), d.inclusive === !0 || void 0 === d.inclusive ? {
                valid: e >= f,
                message: a.fn.bootstrapValidator.helpers.format(d.message || a.fn.bootstrapValidator.i18n.greaterThan["default"], f)
            } : {
                valid: e > f,
                message: a.fn.bootstrapValidator.helpers.format(d.message || a.fn.bootstrapValidator.i18n.greaterThan.notInclusive, f)
            }
        }
    }
}(window.jQuery),
function(a) {
    a.fn.bootstrapValidator.i18n.identical = a.extend(a.fn.bootstrapValidator.i18n.identical || {}, {
        "default": "Please enter the same value"
    }), a.fn.bootstrapValidator.validators.identical = {
        html5Attributes: {
            message: "message",
            field: "field"
        },
        validate: function(a, b, c) {
            var d = b.val();
            if ("" === d) return !0;
            var e = a.getFieldElements(c.field);
            return null === e || 0 === e.length ? !0 : d === e.val() ? (a.updateStatus(c.field, a.STATUS_VALID, "identical"), !0) : !1
        }
    }
}(window.jQuery),
function(a) {
    a.fn.bootstrapValidator.i18n.integer = a.extend(a.fn.bootstrapValidator.i18n.integer || {}, {
        "default": "Please enter a valid number"
    }), a.fn.bootstrapValidator.validators.integer = {
        enableByHtml5: function(a) {
            return "number" === a.attr("type") && (void 0 === a.attr("step") || a.attr("step") % 1 === 0)
        },
        validate: function(a, b) {
            if (this.enableByHtml5(b) && b.get(0).validity && b.get(0).validity.badInput === !0) return !1;
            var c = b.val();
            return "" === c ? !0 : /^(?:-?(?:0|[1-9][0-9]*))$/.test(c)
        }
    }
}(window.jQuery),
function(a) {
    a.fn.bootstrapValidator.i18n.lessThan = a.extend(a.fn.bootstrapValidator.i18n.lessThan || {}, {
        "default": "Please enter a value less than or equal to %s",
        notInclusive: "Please enter a value less than %s"
    }), a.fn.bootstrapValidator.validators.lessThan = {
        html5Attributes: {
            message: "message",
            value: "value",
            inclusive: "inclusive"
        },
        enableByHtml5: function(a) {
            var b = a.attr("type"),
                c = a.attr("max");
            return c && "date" !== b ? {
                value: c
            } : !1
        },
        validate: function(b, c, d) {
            var e = c.val();
            if ("" === e) return !0;
            if (!a.isNumeric(e)) return !1;
            var f = a.isNumeric(d.value) ? d.value : b.getDynamicOption(c, d.value);
            return e = parseFloat(e), d.inclusive === !0 || void 0 === d.inclusive ? {
                valid: f >= e,
                message: a.fn.bootstrapValidator.helpers.format(d.message || a.fn.bootstrapValidator.i18n.lessThan["default"], f)
            } : {
                valid: f > e,
                message: a.fn.bootstrapValidator.helpers.format(d.message || a.fn.bootstrapValidator.i18n.lessThan.notInclusive, f)
            }
        }
    }
}(window.jQuery),
function(a) {
    a.fn.bootstrapValidator.i18n.notEmpty = a.extend(a.fn.bootstrapValidator.i18n.notEmpty || {}, {
        "default": "Please enter a value"
    }), a.fn.bootstrapValidator.validators.notEmpty = {
        enableByHtml5: function(a) {
            var b = a.attr("required") + "";
            return "required" === b || "true" === b
        },
        validate: function(b, c) {
            var d = c.attr("type");
            return "radio" === d || "checkbox" === d ? b.getFieldElements(c.attr("data-bv-field")).filter(":checked").length > 0 : "number" === d && c.get(0).validity && c.get(0).validity.badInput === !0 ? !0 : "" !== a.trim(c.val())
        }
    }
}(window.jQuery),
function(a) {
    a.fn.bootstrapValidator.i18n.numeric = a.extend(a.fn.bootstrapValidator.i18n.numeric || {}, {
        "default": "Please enter a valid float number"
    }), a.fn.bootstrapValidator.validators.numeric = {
        html5Attributes: {
            message: "message",
            separator: "separator"
        },
        enableByHtml5: function(a) {
            return "number" === a.attr("type") && void 0 !== a.attr("step") && a.attr("step") % 1 !== 0
        },
        validate: function(a, b, c) {
            if (this.enableByHtml5(b) && b.get(0).validity && b.get(0).validity.badInput === !0) return !1;
            var d = b.val();
            if ("" === d) return !0;
            var e = c.separator || ".";
            return "." !== e && (d = d.replace(e, ".")), !isNaN(parseFloat(d)) && isFinite(d)
        }
    }
}(window.jQuery),
function(a) {
    a.fn.bootstrapValidator.i18n.phone = a.extend(a.fn.bootstrapValidator.i18n.phone || {}, {
        "default": "정확한 핸드폰번호를 입력해주세요.",
    }), a.fn.bootstrapValidator.validators.phone = {
        html5Attributes: {
            message: "message"
        },
        validate: function(b, c, d) {
            var e = c.val();
            if ("" === e) return !0;
            var g = !0;
                e = a.trim(e),
                g = /^(01[016789]{1}|02|0[3-9]{1}[0-9]{1})-?[0-9]{3,4}-?[0-9]{4}$/.test(e) && 11 === e.length
            return {
                valid: g,
                message: a.fn.bootstrapValidator.helpers.format(d.message)
            }
        }
    }
}(window.jQuery),
function(a) {
    a.fn.bootstrapValidator.i18n.regexp = a.extend(a.fn.bootstrapValidator.i18n.regexp || {}, {
        "default": "Please enter a value matching the pattern"
    }), a.fn.bootstrapValidator.validators.regexp = {
        html5Attributes: {
            message: "message",
            regexp: "regexp"
        },
        enableByHtml5: function(a) {
            var b = a.attr("pattern");
            return b ? {
                regexp: b
            } : !1
        },
        validate: function(a, b, c) {
            var d = b.val();
            if ("" === d) return !0;
            var e = "string" == typeof c.regexp ? new RegExp(c.regexp) : c.regexp;
            return e.test(d)
        }
    }
}(window.jQuery),
function(a) {
    a.fn.bootstrapValidator.i18n.remote = a.extend(a.fn.bootstrapValidator.i18n.remote || {}, {
        "default": "Please enter a valid value"
    }), a.fn.bootstrapValidator.validators.remote = {
        html5Attributes: {
            message: "message",
            name: "name",
            type: "type",
            url: "url",
            delay: "delay"
        },
        destroy: function(a, b) {
            b.data("bv.remote.timer") && (clearTimeout(b.data("bv.remote.timer")), b.removeData("bv.remote.timer"))
        },
        validate: function(b, c, d) {
            function e() {
                var b = a.ajax({
                    type: k,
                    headers: l,
                    url: j,
                    dataType: "json",
                    data: i
                });
                return b.then(function(a) {
                    a.valid = a.valid === !0 || "true" === a.valid, g.resolve(c, "remote", a)
                }), g.fail(function() {
                    b.abort()
                }), g
            }
            var f = c.val(),
                g = new a.Deferred;
            if ("" === f) return g.resolve(c, "remote", {
                valid: !0
            }), g;
            var h = c.attr("data-bv-field"),
                i = d.data || {},
                j = d.url,
                k = d.type || "GET",
                l = d.headers || {};
            return "function" == typeof i && (i = i.call(this, b)), "function" == typeof j && (j = j.call(this, b)), i[d.name || h] = f, d.delay ? (c.data("bv.remote.timer") && clearTimeout(c.data("bv.remote.timer")), c.data("bv.remote.timer", setTimeout(e, d.delay)), g) : e()
        }
    }
}(window.jQuery),
function(a) {
    a.fn.bootstrapValidator.i18n.step = a.extend(a.fn.bootstrapValidator.i18n.step || {}, {
        "default": "Please enter a valid step of %s"
    }), a.fn.bootstrapValidator.validators.step = {
        html5Attributes: {
            message: "message",
            base: "baseValue",
            step: "step"
        },
        validate: function(b, c, d) {
            var e = c.val();
            if ("" === e) return !0;
            if (d = a.extend({}, {
                    baseValue: 0,
                    step: 1
                }, d), e = parseFloat(e), !a.isNumeric(e)) return !1;
            var f = function(a, b) {
                    var c = Math.pow(10, b);
                    a *= c;
                    var d = a > 0 | -(0 > a),
                        e = a % 1 === .5 * d;
                    return e ? (Math.floor(a) + (d > 0)) / c : Math.round(a) / c
                },
                g = function(a, b) {
                    if (0 === b) return 1;
                    var c = (a + "").split("."),
                        d = (b + "").split("."),
                        e = (1 === c.length ? 0 : c[1].length) + (1 === d.length ? 0 : d[1].length);
                    return f(a - b * Math.floor(a / b), e)
                },
                h = g(e - d.baseValue, d.step);
            return {
                valid: 0 === h || h === d.step,
                message: a.fn.bootstrapValidator.helpers.format(d.message || a.fn.bootstrapValidator.i18n.step["default"], [d.step])
            }
        }
    }
}(window.jQuery),
function(a) {
    a.fn.bootstrapValidator.i18n.stringCase = a.extend(a.fn.bootstrapValidator.i18n.stringCase || {}, {
        "default": "Please enter only lowercase characters",
        upper: "Please enter only uppercase characters"
    }), a.fn.bootstrapValidator.validators.stringCase = {
        html5Attributes: {
            message: "message",
            "case": "case"
        },
        validate: function(b, c, d) {
            var e = c.val();
            if ("" === e) return !0;
            var f = (d["case"] || "lower").toLowerCase();
            return {
                valid: "upper" === f ? e === e.toUpperCase() : e === e.toLowerCase(),
                message: d.message || ("upper" === f ? a.fn.bootstrapValidator.i18n.stringCase.upper : a.fn.bootstrapValidator.i18n.stringCase["default"])
            }
        }
    }
}(window.jQuery),
function(a) {
    a.fn.bootstrapValidator.i18n.stringLength = a.extend(a.fn.bootstrapValidator.i18n.stringLength || {}, {
        "default": "Please enter a value with valid length",
        less: "Please enter less than %s characters",
        more: "Please enter more than %s characters",
        between: "Please enter value between %s and %s characters long"
    }), a.fn.bootstrapValidator.validators.stringLength = {
        html5Attributes: {
            message: "message",
            min: "min",
            max: "max"
        },
        enableByHtml5: function(b) {
            var c = {},
                d = b.attr("maxlength"),
                e = b.attr("minlength");
            return d && (c.max = parseInt(d, 10)), e && (c.min = parseInt(e, 10)), a.isEmptyObject(c) ? !1 : c
        },
        validate: function(b, c, d) {
            var e = c.val();
            if ("" === e) return !0;
            var f = a.isNumeric(d.min) ? d.min : b.getDynamicOption(c, d.min),
                g = a.isNumeric(d.max) ? d.max : b.getDynamicOption(c, d.max),
                h = e.length,
                i = !0,
                j = d.message || a.fn.bootstrapValidator.i18n.stringLength["default"];
            switch ((f && h < parseInt(f, 10) || g && h > parseInt(g, 10)) && (i = !1), !0) {
                case !!f && !!g:
                    j = a.fn.bootstrapValidator.helpers.format(d.message || a.fn.bootstrapValidator.i18n.stringLength.between, [parseInt(f, 10), parseInt(g, 10)]);
                    break;
                case !!f:
                    j = a.fn.bootstrapValidator.helpers.format(d.message || a.fn.bootstrapValidator.i18n.stringLength.more, parseInt(f, 10));
                    break;
                case !!g:
                    j = a.fn.bootstrapValidator.helpers.format(d.message || a.fn.bootstrapValidator.i18n.stringLength.less, parseInt(g, 10))
            }
            return {
                valid: i,
                message: j
            }
        }
    }
}(window.jQuery);