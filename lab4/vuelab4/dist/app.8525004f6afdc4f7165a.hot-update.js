webpackHotUpdate("app",{

/***/ "./node_modules/cache-loader/dist/cjs.js?!./node_modules/babel-loader/lib/index.js!./node_modules/cache-loader/dist/cjs.js?!./node_modules/vue-loader/lib/index.js?!./src/views/LabMode.vue?vue&type=script&lang=js&":
/*!***********************************************************************************************************************************************************************************************************************************************!*\
  !*** ./node_modules/cache-loader/dist/cjs.js??ref--12-0!./node_modules/babel-loader/lib!./node_modules/cache-loader/dist/cjs.js??ref--0-0!./node_modules/vue-loader/lib??vue-loader-options!./src/views/LabMode.vue?vue&type=script&lang=js& ***!
  \***********************************************************************************************************************************************************************************************************************************************/
/*! exports provided: default */
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
eval("__webpack_require__.r(__webpack_exports__);\n/* harmony import */ var _home_sundalik_ITMO3_WEB_ITMO_lab4_vuelab4_node_modules_babel_runtime_corejs2_core_js_parse_float__WEBPACK_IMPORTED_MODULE_0__ = __webpack_require__(/*! ./node_modules/@babel/runtime-corejs2/core-js/parse-float */ \"./node_modules/@babel/runtime-corejs2/core-js/parse-float.js\");\n/* harmony import */ var _home_sundalik_ITMO3_WEB_ITMO_lab4_vuelab4_node_modules_babel_runtime_corejs2_core_js_parse_float__WEBPACK_IMPORTED_MODULE_0___default = /*#__PURE__*/__webpack_require__.n(_home_sundalik_ITMO3_WEB_ITMO_lab4_vuelab4_node_modules_babel_runtime_corejs2_core_js_parse_float__WEBPACK_IMPORTED_MODULE_0__);\n/* harmony import */ var core_js_modules_web_dom_iterable__WEBPACK_IMPORTED_MODULE_1__ = __webpack_require__(/*! core-js/modules/web.dom.iterable */ \"./node_modules/core-js/modules/web.dom.iterable.js\");\n/* harmony import */ var core_js_modules_web_dom_iterable__WEBPACK_IMPORTED_MODULE_1___default = /*#__PURE__*/__webpack_require__.n(core_js_modules_web_dom_iterable__WEBPACK_IMPORTED_MODULE_1__);\n/* harmony import */ var regenerator_runtime_runtime__WEBPACK_IMPORTED_MODULE_2__ = __webpack_require__(/*! regenerator-runtime/runtime */ \"./node_modules/regenerator-runtime/runtime.js\");\n/* harmony import */ var regenerator_runtime_runtime__WEBPACK_IMPORTED_MODULE_2___default = /*#__PURE__*/__webpack_require__.n(regenerator_runtime_runtime__WEBPACK_IMPORTED_MODULE_2__);\n/* harmony import */ var _home_sundalik_ITMO3_WEB_ITMO_lab4_vuelab4_node_modules_babel_runtime_corejs2_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_3__ = __webpack_require__(/*! ./node_modules/@babel/runtime-corejs2/helpers/esm/asyncToGenerator */ \"./node_modules/@babel/runtime-corejs2/helpers/esm/asyncToGenerator.js\");\n/* harmony import */ var _components_PaperTable__WEBPACK_IMPORTED_MODULE_4__ = __webpack_require__(/*! ../components/PaperTable */ \"./src/components/PaperTable.vue\");\n/* harmony import */ var _components_GraphPanel__WEBPACK_IMPORTED_MODULE_5__ = __webpack_require__(/*! ../components/GraphPanel */ \"./src/components/GraphPanel.vue\");\n/* harmony import */ var _api__WEBPACK_IMPORTED_MODULE_6__ = __webpack_require__(/*! ../api */ \"./src/api.js\");\n\n\n\n\n//\n//\n//\n//\n//\n//\n//\n//\n//\n//\n//\n//\n//\n//\n//\n//\n//\n//\n//\n//\n//\n//\n//\n//\n//\n//\n//\n//\n//\n//\n//\n//\n//\n//\n//\n//\n//\n//\n//\n//\n//\n//\n//\n//\n//\n//\n//\n//\n//\n\n\n\n/* harmony default export */ __webpack_exports__[\"default\"] = ({\n  name: \"LabMode\",\n  components: {\n    GraphPanel: _components_GraphPanel__WEBPACK_IMPORTED_MODULE_5__[\"default\"],\n    PaperTable: _components_PaperTable__WEBPACK_IMPORTED_MODULE_4__[\"default\"]\n  },\n  data: function data() {\n    return {\n      r: null,\n      results: []\n    };\n  },\n  methods: {\n    mount: function () {\n      var _mount = Object(_home_sundalik_ITMO3_WEB_ITMO_lab4_vuelab4_node_modules_babel_runtime_corejs2_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_3__[\"default\"])(\n      /*#__PURE__*/\n      regeneratorRuntime.mark(function _callee() {\n        var response;\n        return regeneratorRuntime.wrap(function _callee$(_context) {\n          while (1) {\n            switch (_context.prev = _context.next) {\n              case 0:\n                console.log(\"penis\");\n                _context.next = 3;\n                return Object(_api__WEBPACK_IMPORTED_MODULE_6__[\"getLabDots\"])();\n\n              case 3:\n                response = _context.sent;\n                response.forEach(function (dot) {\n                  this.addDot(dot.r, dot.x, dot.y, dot.figura, dot.time);\n                });\n\n              case 5:\n              case \"end\":\n                return _context.stop();\n            }\n          }\n        }, _callee, this);\n      }));\n\n      function mount() {\n        return _mount.apply(this, arguments);\n      }\n\n      return mount;\n    }(),\n    setR: function setR(_ref) {\n      var r = _ref.r;\n      this.r = r;\n      var graphDots = document.getElementById(\"graphDots\");\n\n      while (graphDots.firstChild) {\n        graphDots.removeChild(graphDots.firstChild);\n      }\n\n      this.results.forEach(function (dot) {\n        this.addDot(dot.r, dot.x, dot.y, dot.figura, dot.time, false);\n      });\n    },\n    addDotFromPanel: function () {\n      var _addDotFromPanel = Object(_home_sundalik_ITMO3_WEB_ITMO_lab4_vuelab4_node_modules_babel_runtime_corejs2_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_3__[\"default\"])(\n      /*#__PURE__*/\n      regeneratorRuntime.mark(function _callee2(_ref2) {\n        var x, y, response;\n        return regeneratorRuntime.wrap(function _callee2$(_context2) {\n          while (1) {\n            switch (_context2.prev = _context2.next) {\n              case 0:\n                x = _ref2.x, y = _ref2.y;\n                _context2.next = 3;\n                return Object(_api__WEBPACK_IMPORTED_MODULE_6__[\"postSetDot\"])(_home_sundalik_ITMO3_WEB_ITMO_lab4_vuelab4_node_modules_babel_runtime_corejs2_core_js_parse_float__WEBPACK_IMPORTED_MODULE_0___default()(x), _home_sundalik_ITMO3_WEB_ITMO_lab4_vuelab4_node_modules_babel_runtime_corejs2_core_js_parse_float__WEBPACK_IMPORTED_MODULE_0___default()(y), _home_sundalik_ITMO3_WEB_ITMO_lab4_vuelab4_node_modules_babel_runtime_corejs2_core_js_parse_float__WEBPACK_IMPORTED_MODULE_0___default()(this.r));\n\n              case 3:\n                response = _context2.sent;\n                _context2.next = 6;\n                return this.addDot(this.r, x, y, response.figura, response.time);\n\n              case 6:\n              case \"end\":\n                return _context2.stop();\n            }\n          }\n        }, _callee2, this);\n      }));\n\n      function addDotFromPanel(_x) {\n        return _addDotFromPanel.apply(this, arguments);\n      }\n\n      return addDotFromPanel;\n    }(),\n    addDotFromGraph: function () {\n      var _addDotFromGraph = Object(_home_sundalik_ITMO3_WEB_ITMO_lab4_vuelab4_node_modules_babel_runtime_corejs2_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_3__[\"default\"])(\n      /*#__PURE__*/\n      regeneratorRuntime.mark(function _callee3(e) {\n        var x, y, response;\n        return regeneratorRuntime.wrap(function _callee3$(_context3) {\n          while (1) {\n            switch (_context3.prev = _context3.next) {\n              case 0:\n                x = (e.clientX - document.getElementById(\"mainGraph\").getBoundingClientRect().left - 200) / 160 * this.r;\n                y = -(e.clientY - document.getElementById(\"mainGraph\").getBoundingClientRect().top - 200) / 160 * this.r;\n                _context3.next = 4;\n                return Object(_api__WEBPACK_IMPORTED_MODULE_6__[\"postSetDot\"])(_home_sundalik_ITMO3_WEB_ITMO_lab4_vuelab4_node_modules_babel_runtime_corejs2_core_js_parse_float__WEBPACK_IMPORTED_MODULE_0___default()(x), _home_sundalik_ITMO3_WEB_ITMO_lab4_vuelab4_node_modules_babel_runtime_corejs2_core_js_parse_float__WEBPACK_IMPORTED_MODULE_0___default()(y), _home_sundalik_ITMO3_WEB_ITMO_lab4_vuelab4_node_modules_babel_runtime_corejs2_core_js_parse_float__WEBPACK_IMPORTED_MODULE_0___default()(this.r));\n\n              case 4:\n                response = _context3.sent;\n                _context3.next = 7;\n                return this.addDot(this.r, x, y, response.figura, response.time);\n\n              case 7:\n              case \"end\":\n                return _context3.stop();\n            }\n          }\n        }, _callee3, this);\n      }));\n\n      function addDotFromGraph(_x2) {\n        return _addDotFromGraph.apply(this, arguments);\n      }\n\n      return addDotFromGraph;\n    }(),\n    addDot: function () {\n      var _addDot = Object(_home_sundalik_ITMO3_WEB_ITMO_lab4_vuelab4_node_modules_babel_runtime_corejs2_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_3__[\"default\"])(\n      /*#__PURE__*/\n      regeneratorRuntime.mark(function _callee4() {\n        var r,\n            x,\n            y,\n            figura,\n            time,\n            ifAddToTable,\n            graphX,\n            graphY,\n            circle,\n            _args4 = arguments;\n        return regeneratorRuntime.wrap(function _callee4$(_context4) {\n          while (1) {\n            switch (_context4.prev = _context4.next) {\n              case 0:\n                r = _args4.length > 0 && _args4[0] !== undefined ? _args4[0] : this.r;\n                x = _args4.length > 1 ? _args4[1] : undefined;\n                y = _args4.length > 2 ? _args4[2] : undefined;\n                figura = _args4.length > 3 ? _args4[3] : undefined;\n                time = _args4.length > 4 ? _args4[4] : undefined;\n                ifAddToTable = _args4.length > 5 && _args4[5] !== undefined ? _args4[5] : true;\n                graphX = x * 160 / r;\n                graphY = -y * 160 / r;\n                circle = document.createElementNS(this.svgns, 'circle');\n                circle.setAttributeNS(null, 'cx', graphX);\n                circle.setAttributeNS(null, 'cy', graphY);\n                circle.setAttributeNS(null, 'r', '3');\n\n                if (figura) {\n                  circle.setAttributeNS(null, 'style', 'fill: black; stroke: white; stroke-width: 1px;');\n                } else {\n                  circle.setAttributeNS(null, 'style', 'fill: white; stroke: black; stroke-width: 1px;');\n                }\n\n                document.getElementById(\"graphDots\").appendChild(circle);\n                if (ifAddToTable) this.results.push({\n                  r: r,\n                  x: x,\n                  y: y,\n                  figura: figura,\n                  time: time\n                });\n\n              case 15:\n              case \"end\":\n                return _context4.stop();\n            }\n          }\n        }, _callee4, this);\n      }));\n\n      function addDot() {\n        return _addDot.apply(this, arguments);\n      }\n\n      return addDot;\n    }(),\n    removeAllDots: function () {\n      var _removeAllDots = Object(_home_sundalik_ITMO3_WEB_ITMO_lab4_vuelab4_node_modules_babel_runtime_corejs2_helpers_esm_asyncToGenerator__WEBPACK_IMPORTED_MODULE_3__[\"default\"])(\n      /*#__PURE__*/\n      regeneratorRuntime.mark(function _callee5() {\n        var graphDots;\n        return regeneratorRuntime.wrap(function _callee5$(_context5) {\n          while (1) {\n            switch (_context5.prev = _context5.next) {\n              case 0:\n                _context5.next = 2;\n                return Object(_api__WEBPACK_IMPORTED_MODULE_6__[\"postEraseDots\"])();\n\n              case 2:\n                if (!_context5.sent) {\n                  _context5.next = 6;\n                  break;\n                }\n\n                this.results = [];\n                graphDots = document.getElementById(\"graphDots\");\n\n                while (graphDots.firstChild) {\n                  graphDots.removeChild(graphDots.firstChild);\n                }\n\n              case 6:\n              case \"end\":\n                return _context5.stop();\n            }\n          }\n        }, _callee5, this);\n      }));\n\n      function removeAllDots() {\n        return _removeAllDots.apply(this, arguments);\n      }\n\n      return removeAllDots;\n    }()\n  }\n});//# sourceURL=[module]\n//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoiLi9ub2RlX21vZHVsZXMvY2FjaGUtbG9hZGVyL2Rpc3QvY2pzLmpzPyEuL25vZGVfbW9kdWxlcy9iYWJlbC1sb2FkZXIvbGliL2luZGV4LmpzIS4vbm9kZV9tb2R1bGVzL2NhY2hlLWxvYWRlci9kaXN0L2Nqcy5qcz8hLi9ub2RlX21vZHVsZXMvdnVlLWxvYWRlci9saWIvaW5kZXguanM/IS4vc3JjL3ZpZXdzL0xhYk1vZGUudnVlP3Z1ZSZ0eXBlPXNjcmlwdCZsYW5nPWpzJi5qcyIsInNvdXJjZXMiOlsid2VicGFjazovLy9MYWJNb2RlLnZ1ZT80MDI5Il0sInNvdXJjZXNDb250ZW50IjpbIjx0ZW1wbGF0ZT5cbiAgICA8ZGl2IGNsYXNzPVwiZ2FtZVBhZ2VcIj5cbiAgICAgICAgPGRpdiBjbGFzcz1cImxhYkdyaWRcIj5cbiAgICAgICAgICAgIDxkaXYgY2xhc3M9XCJncmlkLS1leGl0XCI+XG4gICAgICAgICAgICAgICAgPHJvdXRlci1saW5rIHRvPVwiTWFpbk1lbnVcIiBjbGFzcz1cImV4aXRCdXR0b25cIj5cbiAgICAgICAgICAgICAgICAgICAgTWFpbiBNZW51XG4gICAgICAgICAgICAgICAgPC9yb3V0ZXItbGluaz5cbiAgICAgICAgICAgIDwvZGl2PlxuICAgICAgICAgICAgPGRpdiBjbGFzcz1cImdyaWQtLWdyYXBoIGZsZXhDb2x1bW5cIj5cbiAgICAgICAgICAgICAgICA8c3ZnIHhtbG5zPVwiaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmdcIiB2aWV3Qm94PVwiMCAwIDQwMCA0MDBcIiBjbGFzcz1cIm1haW5QcmFjdGljZUdyYXBoXCJcbiAgICAgICAgICAgICAgICAgICAgIEBjbGljaz1cImFkZERvdEZyb21HcmFwaFwiIGlkPVwibWFpbkdyYXBoXCI+XG4gICAgICAgICAgICAgICAgICAgIDxnIHN0cm9rZT1cIndoaXRlXCIgc3Ryb2tlLXdpZHRoPVwiMnB4XCI+XG4gICAgICAgICAgICAgICAgICAgICAgICA8cGF0aCBkPVwiTSAwIDIwMCBoIDQwMFwiPjwvcGF0aD5cbiAgICAgICAgICAgICAgICAgICAgICAgIDxwYXRoIGQ9XCJNIDIwMCAwIHYgNDAwXCI+PC9wYXRoPlxuICAgICAgICAgICAgICAgICAgICAgICAgPHBhdGggZD1cIk0gMjAwIDAgbCAtNCA3XCI+PC9wYXRoPlxuICAgICAgICAgICAgICAgICAgICAgICAgPHBhdGggZD1cIk0gMjAwIDAgbCA0IDdcIj48L3BhdGg+XG4gICAgICAgICAgICAgICAgICAgICAgICA8cGF0aCBkPVwiTSA0MDAgMjAwIGwgLTcgLTRcIj48L3BhdGg+XG4gICAgICAgICAgICAgICAgICAgICAgICA8cGF0aCBkPVwiTSA0MDAgMjAwIGwgLTcgNFwiPjwvcGF0aD5cbiAgICAgICAgICAgICAgICAgICAgICAgIDxwYXRoIGQ9XCJNIDAgMCBoIDUwXCI+PC9wYXRoPlxuICAgICAgICAgICAgICAgICAgICAgICAgPHBhdGggZD1cIk0gMCAwIHYgNTBcIj48L3BhdGg+XG4gICAgICAgICAgICAgICAgICAgICAgICA8cGF0aCBkPVwiTSA0MDAgMCBoIC01MFwiPjwvcGF0aD5cbiAgICAgICAgICAgICAgICAgICAgICAgIDxwYXRoIGQ9XCJNIDQwMCAwIHYgNTBcIj48L3BhdGg+XG4gICAgICAgICAgICAgICAgICAgICAgICA8cGF0aCBkPVwiTSAwIDQwMCBoIDUwXCI+PC9wYXRoPlxuICAgICAgICAgICAgICAgICAgICAgICAgPHBhdGggZD1cIk0gMCA0MDAgdiAtNTBcIj48L3BhdGg+XG4gICAgICAgICAgICAgICAgICAgICAgICA8cGF0aCBkPVwiTSA0MDAgNDAwIGggLTUwXCI+PC9wYXRoPlxuICAgICAgICAgICAgICAgICAgICAgICAgPHBhdGggZD1cIk0gNDAwIDQwMCB2IC01MFwiPjwvcGF0aD5cbiAgICAgICAgICAgICAgICAgICAgPC9nPlxuICAgICAgICAgICAgICAgICAgICA8cGF0aCBzdHJva2U9XCJ3aGl0ZVwiIGZpbGw9XCJ3aGl0ZVwiIGQ9XCJNIDIwMCAyMDAgaCAtMTYwIHYgLTgwIGggMTYwIFpcIj48L3BhdGg+XG4gICAgICAgICAgICAgICAgICAgIDxwYXRoIHN0cm9rZT1cIndoaXRlXCIgZmlsbD1cIndoaXRlXCIgZD1cIk0gMjAwIDIwMCB2IC04MCBxIDgwIDAgODAgODAgWlwiPjwvcGF0aD5cbiAgICAgICAgICAgICAgICAgICAgPHBhdGggc3Ryb2tlPVwid2hpdGVcIiBmaWxsPVwid2hpdGVcIiBkPVwiTSAyMDAgMjAwIHYgODAgbCAtMTYwIC04MCBaXCI+PC9wYXRoPlxuXG4gICAgICAgICAgICAgICAgICAgIDxwYXRoIHN0cm9rZT1cImJsYWNrXCIgc3Ryb2tlLXdpZHRoPVwiMnB4XCIgZD1cIk0gMjAwIDIwMCBoIC0xNjBcIj48L3BhdGg+XG4gICAgICAgICAgICAgICAgICAgIDxwYXRoIHN0cm9rZT1cImJsYWNrXCIgc3Ryb2tlLXdpZHRoPVwiMnB4XCIgZD1cIk0gMjAwIDIwMCBoIDgwXCI+PC9wYXRoPlxuICAgICAgICAgICAgICAgICAgICA8cGF0aCBzdHJva2U9XCJibGFja1wiIHN0cm9rZS13aWR0aD1cIjJweFwiIGQ9XCJNIDIwMCAyMDAgdiA4MFwiPjwvcGF0aD5cbiAgICAgICAgICAgICAgICAgICAgPHBhdGggc3Ryb2tlPVwiYmxhY2tcIiBzdHJva2Utd2lkdGg9XCIycHhcIiBkPVwiTSAyMDAgMjAwIHYgLTgwXCI+PC9wYXRoPlxuXG4gICAgICAgICAgICAgICAgICAgIDx0ZXh0IHN0cm9rZT1cIndoaXRlXCIgZmlsbD1cIndoaXRlXCIgZm9udC1zaXplPVwiMjJweFwiIHg9XCIzMlwiIHk9XCIyMjVcIj5SPC90ZXh0PlxuICAgICAgICAgICAgICAgICAgICA8dGV4dCBzdHJva2U9XCJ3aGl0ZVwiIGZpbGw9XCJ3aGl0ZVwiIGZvbnQtc2l6ZT1cIjIycHhcIiB4PVwiMjY1XCIgeT1cIjIyNVwiPlIvMjwvdGV4dD5cbiAgICAgICAgICAgICAgICAgICAgPHRleHQgc3Ryb2tlPVwid2hpdGVcIiBmaWxsPVwid2hpdGVcIiBmb250LXNpemU9XCIyMnB4XCIgeD1cIjE1MFwiIHk9XCIxMTBcIj5SLzI8L3RleHQ+XG4gICAgICAgICAgICAgICAgICAgIDx0ZXh0IHN0cm9rZT1cIndoaXRlXCIgZmlsbD1cIndoaXRlXCIgZm9udC1zaXplPVwiMjJweFwiIHg9XCIyMTBcIiB5PVwiMjg1XCI+Ui8yPC90ZXh0PlxuICAgICAgICAgICAgICAgICAgICA8ZyBpZD1cImdyYXBoRG90c1wiPjwvZz5cbiAgICAgICAgICAgICAgICA8L3N2Zz5cbiAgICAgICAgICAgIDwvZGl2PlxuICAgICAgICAgICAgPEdyYXBoUGFuZWwgaWQ9XCJwYW5lbFwiIEBjaGFuZ2Utcj1cInNldFJcIiBAYWRkLWRhdGE9XCJhZGREb3RGcm9tUGFuZWxcIiBAZXJhc2UtZGF0YT1cInJlbW92ZUFsbERvdHNcIi8+XG4gICAgICAgICAgICA8UGFwZXJUYWJsZSA6cmVzdWx0cz1cInJlc3VsdHNcIi8+XG4gICAgICAgIDwvZGl2PlxuICAgIDwvZGl2PlxuPC90ZW1wbGF0ZT5cblxuPHNjcmlwdD5cbiAgICBpbXBvcnQgUGFwZXJUYWJsZSBmcm9tIFwiLi4vY29tcG9uZW50cy9QYXBlclRhYmxlXCI7XG4gICAgaW1wb3J0IEdyYXBoUGFuZWwgZnJvbSBcIi4uL2NvbXBvbmVudHMvR3JhcGhQYW5lbFwiO1xuICAgIGltcG9ydCB7cG9zdFNldERvdCwgZ2V0TGFiRG90cywgcG9zdEVyYXNlRG90c30gZnJvbSBcIi4uL2FwaVwiO1xuXG4gICAgZXhwb3J0IGRlZmF1bHQge1xuICAgICAgICBuYW1lOiBcIkxhYk1vZGVcIixcbiAgICAgICAgY29tcG9uZW50czoge0dyYXBoUGFuZWwsIFBhcGVyVGFibGV9LFxuICAgICAgICBkYXRhOiBmdW5jdGlvbiAoKSB7XG4gICAgICAgICAgICByZXR1cm4ge1xuICAgICAgICAgICAgICAgIHI6IG51bGwsXG4gICAgICAgICAgICAgICAgcmVzdWx0czogW11cbiAgICAgICAgICAgIH1cbiAgICAgICAgfSxcbiAgICAgICAgbWV0aG9kczoge1xuICAgICAgICAgICAgYXN5bmMgbW91bnQoKSB7XG4gICAgICAgICAgICAgICAgY29uc29sZS5sb2coXCJwZW5pc1wiKTtcbiAgICAgICAgICAgICAgICBjb25zdCByZXNwb25zZSA9IGF3YWl0IGdldExhYkRvdHMoKTtcbiAgICAgICAgICAgICAgICByZXNwb25zZS5mb3JFYWNoKGZ1bmN0aW9uIChkb3QpIHtcbiAgICAgICAgICAgICAgICAgICAgdGhpcy5hZGREb3QoZG90LnIsIGRvdC54LCBkb3QueSwgZG90LmZpZ3VyYSwgZG90LnRpbWUpO1xuICAgICAgICAgICAgICAgIH0pO1xuICAgICAgICAgICAgfSxcbiAgICAgICAgICAgIHNldFIoe3J9KSB7XG4gICAgICAgICAgICAgICAgdGhpcy5yID0gcjtcbiAgICAgICAgICAgICAgICBsZXQgZ3JhcGhEb3RzID0gZG9jdW1lbnQuZ2V0RWxlbWVudEJ5SWQoXCJncmFwaERvdHNcIik7XG4gICAgICAgICAgICAgICAgd2hpbGUgKGdyYXBoRG90cy5maXJzdENoaWxkKSB7XG4gICAgICAgICAgICAgICAgICAgIGdyYXBoRG90cy5yZW1vdmVDaGlsZChncmFwaERvdHMuZmlyc3RDaGlsZCk7XG4gICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgICAgIHRoaXMucmVzdWx0cy5mb3JFYWNoKGZ1bmN0aW9uIChkb3QpIHtcbiAgICAgICAgICAgICAgICAgICAgdGhpcy5hZGREb3QoZG90LnIsIGRvdC54LCBkb3QueSwgZG90LmZpZ3VyYSwgZG90LnRpbWUsIGZhbHNlKTtcbiAgICAgICAgICAgICAgICB9KVxuICAgICAgICAgICAgfSxcbiAgICAgICAgICAgIGFzeW5jIGFkZERvdEZyb21QYW5lbCh7eCwgeX0pIHtcbiAgICAgICAgICAgICAgICBjb25zdCByZXNwb25zZSA9IGF3YWl0IHBvc3RTZXREb3QocGFyc2VGbG9hdCh4KSwgcGFyc2VGbG9hdCh5KSwgcGFyc2VGbG9hdCh0aGlzLnIpKTtcbiAgICAgICAgICAgICAgICBhd2FpdCB0aGlzLmFkZERvdCh0aGlzLnIsIHgsIHksIHJlc3BvbnNlLmZpZ3VyYSwgcmVzcG9uc2UudGltZSk7XG4gICAgICAgICAgICB9LFxuICAgICAgICAgICAgYXN5bmMgYWRkRG90RnJvbUdyYXBoKGUpIHtcbiAgICAgICAgICAgICAgICBjb25zdCB4ID0gKGUuY2xpZW50WCAtIGRvY3VtZW50LmdldEVsZW1lbnRCeUlkKFwibWFpbkdyYXBoXCIpLmdldEJvdW5kaW5nQ2xpZW50UmVjdCgpLmxlZnQgLSAyMDApIC8gMTYwICogdGhpcy5yO1xuICAgICAgICAgICAgICAgIGNvbnN0IHkgPSAtKGUuY2xpZW50WSAtIGRvY3VtZW50LmdldEVsZW1lbnRCeUlkKFwibWFpbkdyYXBoXCIpLmdldEJvdW5kaW5nQ2xpZW50UmVjdCgpLnRvcCAtIDIwMCkgLyAxNjAgKiB0aGlzLnI7XG4gICAgICAgICAgICAgICAgY29uc3QgcmVzcG9uc2UgPSBhd2FpdCBwb3N0U2V0RG90KHBhcnNlRmxvYXQoeCksIHBhcnNlRmxvYXQoeSksIHBhcnNlRmxvYXQodGhpcy5yKSk7XG4gICAgICAgICAgICAgICAgYXdhaXQgdGhpcy5hZGREb3QodGhpcy5yLCB4LCB5LCByZXNwb25zZS5maWd1cmEsIHJlc3BvbnNlLnRpbWUpO1xuICAgICAgICAgICAgfSxcbiAgICAgICAgICAgIGFzeW5jIGFkZERvdChyID0gdGhpcy5yLCB4LCB5LCBmaWd1cmEsIHRpbWUsIGlmQWRkVG9UYWJsZSA9IHRydWUpIHtcbiAgICAgICAgICAgICAgICBjb25zdCBncmFwaFggPSB4ICogMTYwIC8gcjtcbiAgICAgICAgICAgICAgICBjb25zdCBncmFwaFkgPSAteSAqIDE2MCAvIHI7XG4gICAgICAgICAgICAgICAgY29uc3QgY2lyY2xlID0gZG9jdW1lbnQuY3JlYXRlRWxlbWVudE5TKHRoaXMuc3ZnbnMsICdjaXJjbGUnKTtcbiAgICAgICAgICAgICAgICBjaXJjbGUuc2V0QXR0cmlidXRlTlMobnVsbCwgJ2N4JywgZ3JhcGhYKTtcbiAgICAgICAgICAgICAgICBjaXJjbGUuc2V0QXR0cmlidXRlTlMobnVsbCwgJ2N5JywgZ3JhcGhZKTtcbiAgICAgICAgICAgICAgICBjaXJjbGUuc2V0QXR0cmlidXRlTlMobnVsbCwgJ3InLCAnMycpO1xuICAgICAgICAgICAgICAgIGlmIChmaWd1cmEpIHtcbiAgICAgICAgICAgICAgICAgICAgY2lyY2xlLnNldEF0dHJpYnV0ZU5TKG51bGwsICdzdHlsZScsICdmaWxsOiBibGFjazsgc3Ryb2tlOiB3aGl0ZTsgc3Ryb2tlLXdpZHRoOiAxcHg7Jyk7XG4gICAgICAgICAgICAgICAgfSBlbHNlIHtcbiAgICAgICAgICAgICAgICAgICAgY2lyY2xlLnNldEF0dHJpYnV0ZU5TKG51bGwsICdzdHlsZScsICdmaWxsOiB3aGl0ZTsgc3Ryb2tlOiBibGFjazsgc3Ryb2tlLXdpZHRoOiAxcHg7Jyk7XG4gICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgICAgIGRvY3VtZW50LmdldEVsZW1lbnRCeUlkKFwiZ3JhcGhEb3RzXCIpLmFwcGVuZENoaWxkKGNpcmNsZSk7XG4gICAgICAgICAgICAgICAgaWYgKGlmQWRkVG9UYWJsZSkgdGhpcy5yZXN1bHRzLnB1c2goe3I6IHIsIHg6IHgsIHk6IHksIGZpZ3VyYTogZmlndXJhLCB0aW1lOiB0aW1lfSk7XG4gICAgICAgICAgICB9LFxuICAgICAgICAgICAgYXN5bmMgcmVtb3ZlQWxsRG90cygpIHtcbiAgICAgICAgICAgICAgICBpZiAoYXdhaXQgcG9zdEVyYXNlRG90cygpKSB7XG4gICAgICAgICAgICAgICAgICAgIHRoaXMucmVzdWx0cyA9IFtdO1xuICAgICAgICAgICAgICAgICAgICBsZXQgZ3JhcGhEb3RzID0gZG9jdW1lbnQuZ2V0RWxlbWVudEJ5SWQoXCJncmFwaERvdHNcIik7XG4gICAgICAgICAgICAgICAgICAgIHdoaWxlIChncmFwaERvdHMuZmlyc3RDaGlsZCkge1xuICAgICAgICAgICAgICAgICAgICAgICAgZ3JhcGhEb3RzLnJlbW92ZUNoaWxkKGdyYXBoRG90cy5maXJzdENoaWxkKTtcbiAgICAgICAgICAgICAgICAgICAgfVxuICAgICAgICAgICAgICAgIH1cbiAgICAgICAgICAgIH1cbiAgICAgICAgfVxuICAgIH1cbjwvc2NyaXB0PlxuXG48c3R5bGUgc2NvcGVkPlxuICAgIC5sYWJHcmlkIHtcbiAgICAgICAgZGlzcGxheTogZ3JpZDtcbiAgICAgICAgcGFkZGluZzogMTBweCAyMHB4O1xuICAgICAgICBoZWlnaHQ6IDEwMHZoO1xuICAgICAgICBncmlkLXJvdy1nYXA6IDQwcHg7XG4gICAgICAgIGdyaWQtY29sdW1uLWdhcDogMjBweDtcbiAgICAgICAgZ3JpZDogXCJleGl0IG5vdGhpbmcxIG5vdGhpbmcyIG5vdGhpbmczXCIgYXV0byBcIm5vdGhpbmcwIGdyYXBoIGdyYXBoUGFuZWwgbm90aGluZzNcIiBjYWxjKDMwdmggKyAxMDBweCkgXCJncmFwaFRhYmxlIGdyYXBoVGFibGUgZ3JhcGhUYWJsZSBncmFwaFRhYmxlXCIgYXV0bztcbiAgICAgICAgZ3JpZC10ZW1wbGF0ZS1jb2x1bW5zOiA2ZnIgMTBmciAxMGZyIDZmcjtcbiAgICAgICAgYm94LXNpemluZzogYm9yZGVyLWJveDtcbiAgICB9XG5cbiAgICAuZXhpdEJ1dHRvbiB7XG4gICAgICAgIHRleHQtZGVjb3JhdGlvbjogbm9uZTtcbiAgICAgICAgY29sb3I6IHdoaXRlO1xuICAgICAgICBmb250LXNpemU6IDIwcHg7XG4gICAgfVxuXG4gICAgLmV4aXRCdXR0b246aG92ZXIge1xuICAgICAgICBjdXJzb3I6IHBvaW50ZXI7XG4gICAgICAgIHRleHQtZGVjb3JhdGlvbjogdW5kZXJsaW5lO1xuICAgIH1cblxuICAgIC5ncmlkLS1ncmFwaCB7XG4gICAgICAgIGdyaWQtYXJlYTogZ3JhcGg7XG4gICAgICAgIHVzZXItc2VsZWN0OiBub25lO1xuICAgIH1cblxuICAgIC5ncmlkLS1leGl0IHtcbiAgICAgICAgZ3JpZC1hcmVhOiBleGl0O1xuICAgIH1cblxuICAgIC5tYWluUHJhY3RpY2VHcmFwaCB7XG4gICAgICAgIGN1cnNvcjogcG9pbnRlcjtcbiAgICB9XG5cbiAgICBAbWVkaWEgKG1heC13aWR0aDogMTIwMHB4KSB7XG4gICAgICAgIC5sYWJHcmlkIHtcbiAgICAgICAgICAgIGdyaWQ6IFwiZXhpdCBleGl0IG5vdGhpbmcyIG5vdGhpbmczXCIgYXV0byBcIm5vdGhpbmcwIGdyYXBoIGdyYXBoUGFuZWwgbm90aGluZzNcIiBjYWxjKDMwdmggKyAxMDBweCkgXCJncmFwaFRhYmxlIGdyYXBoVGFibGUgZ3JhcGhUYWJsZSBncmFwaFRhYmxlXCIgYXV0bztcbiAgICAgICAgICAgIGdyaWQtdGVtcGxhdGUtY29sdW1uczogMmZyIDdmciA3ZnIgMWZyO1xuICAgICAgICAgICAgZ3JpZC1jb2x1bW4tZ2FwOiAxNXB4O1xuICAgICAgICAgICAgZ3JpZC1yb3ctZ2FwOiAzMHB4O1xuICAgICAgICB9XG5cbiAgICAgICAgLmdyaWQtLWV4aXQge1xuICAgICAgICAgICAgdGV4dC1hbGlnbjogbGVmdDtcbiAgICAgICAgICAgIG1hcmdpbi10b3A6IDEwcHg7XG4gICAgICAgIH1cblxuICAgICAgICAuZXhpdEJ1dHRvbiB7XG4gICAgICAgICAgICBmb250LXNpemU6IDI1cHg7XG4gICAgICAgIH1cbiAgICB9XG5cbiAgICBAbWVkaWEgKG1heC13aWR0aDogMTA1NXB4KSB7XG4gICAgICAgIC5sYWJHcmlkIHtcbiAgICAgICAgICAgIGdyaWQ6IFwiZXhpdCBleGl0IG5vdGhpbmcyIG5vdGhpbmczXCIgYXV0byBcIm5vdGhpbmcwIGdyYXBoIGdyYXBoUGFuZWwgbm90aGluZzNcIiBjYWxjKDMwdmggKyAxMDBweCkgXCJncmFwaFRhYmxlIGdyYXBoVGFibGUgZ3JhcGhUYWJsZSBncmFwaFRhYmxlXCIgYXV0bztcbiAgICAgICAgICAgIGdyaWQtdGVtcGxhdGUtY29sdW1uczogMC41ZnIgN2ZyIDRmciAwLjVmcjtcbiAgICAgICAgICAgIGdyaWQtY29sdW1uLWdhcDogMzBweDtcbiAgICAgICAgICAgIGdyaWQtcm93LWdhcDogMzBweDtcbiAgICAgICAgfVxuXG4gICAgICAgIC5ncmlkLS1leGl0IHtcbiAgICAgICAgICAgIHRleHQtYWxpZ246IGxlZnQ7XG4gICAgICAgICAgICBtYXJnaW4tdG9wOiAxMHB4O1xuICAgICAgICB9XG5cbiAgICAgICAgLmV4aXRCdXR0b24ge1xuICAgICAgICAgICAgZm9udC1zaXplOiAyNXB4O1xuICAgICAgICB9XG4gICAgfVxuXG4gICAgQG1lZGlhIChtYXgtd2lkdGg6IDg1MHB4KSB7XG4gICAgICAgIC5sYWJHcmlkIHtcbiAgICAgICAgICAgIGdyaWQtdGVtcGxhdGUtcm93czogNTBweCBjYWxjKDM1dmggKyAxMDBweCkgYXV0bztcbiAgICAgICAgICAgIGdyaWQtY29sdW1uLWdhcDogMjBweDtcbiAgICAgICAgICAgIGdyaWQtcm93LWdhcDogMjBweDtcbiAgICAgICAgICAgIGdyaWQtdGVtcGxhdGUtY29sdW1uczogMCAxMGZyIDdmciAwO1xuICAgICAgICB9XG5cbiAgICAgICAgLmV4aXRCdXR0b24ge1xuICAgICAgICAgICAgZm9udC1zaXplOiAyNXB4O1xuICAgICAgICAgICAgYm9yZGVyOiAycHggc29saWQgd2hpdGU7XG4gICAgICAgICAgICBwYWRkaW5nOiAzcHggMTVweDtcbiAgICAgICAgfVxuXG4gICAgICAgIC5leGl0QnV0dG9uOmhvdmVyIHtcbiAgICAgICAgICAgIHRleHQtZGVjb3JhdGlvbjogbm9uZTtcbiAgICAgICAgICAgIGNvbG9yOiBibGFjaztcbiAgICAgICAgICAgIGJhY2tncm91bmQ6IHdoaXRlO1xuICAgICAgICB9XG4gICAgfVxuXG4gICAgQG1lZGlhIChtYXgtd2lkdGg6IDcwMHB4KSB7XG4gICAgICAgIC5sYWJHcmlkIHtcbiAgICAgICAgICAgIGdyaWQ6IFwiZXhpdFwiIGF1dG8gXCJncmFwaFwiIGNhbGMoMzB2aCArIDEwMHB4KSBcImdyYXBoUGFuZWxcIiBhdXRvIFwiZ3JhcGhUYWJsZVwiIGF1dG87XG4gICAgICAgICAgICBncmlkLXJvdy1nYXA6IDE1cHg7XG4gICAgICAgICAgICBncmlkLWNvbHVtbi1nYXA6IDA7XG4gICAgICAgICAgICBwYWRkaW5nOiAwO1xuICAgICAgICAgICAgZ3JpZC10ZW1wbGF0ZS1jb2x1bW5zOiAxZnI7XG4gICAgICAgIH1cbiAgICB9XG5cbiAgICBAbWVkaWEgKG1heC13aWR0aDogNDIwcHgpIHtcbiAgICAgICAgLmxhYkdyaWQge1xuICAgICAgICAgICAgZ3JpZDogXCJleGl0XCIgYXV0byBcImdyYXBoXCIgY2FsYygyNXZoICsgMTAwcHgpIFwiZ3JhcGhQYW5lbFwiIGF1dG8gXCJncmFwaFRhYmxlXCIgYXV0bztcbiAgICAgICAgfVxuICAgIH1cblxuICAgIEBtZWRpYSAobWF4LXdpZHRoOiAzODBweCkge1xuICAgICAgICAubGFiR3JpZCB7XG4gICAgICAgICAgICBncmlkOiBcImV4aXRcIiBhdXRvIFwiZ3JhcGhcIiBjYWxjKDI1dmgpIFwiZ3JhcGhQYW5lbFwiIGF1dG8gXCJncmFwaFRhYmxlXCIgYXV0bztcbiAgICAgICAgfVxuICAgIH1cbjwvc3R5bGU+Il0sIm1hcHBpbmdzIjoiOzs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7O0FBa0RBO0FBQ0E7QUFDQTtBQUVBO0FBQ0E7QUFDQTtBQUFBO0FBQUE7QUFBQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBRkE7QUFJQTtBQUNBO0FBQ0E7QUFEQTtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBRUE7QUFGQTtBQUFBO0FBQ0E7QUFEQTtBQUdBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFQQTtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUNBO0FBREE7QUFBQTtBQUFBO0FBQ0E7QUFEQTtBQUFBO0FBUUE7QUFBQTtBQUNBO0FBQ0E7QUFDQTtBQUFBO0FBQ0E7QUFDQTtBQUNBO0FBQUE7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQWxCQTtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBa0JBO0FBbEJBO0FBQUE7QUFDQTtBQURBO0FBbUJBO0FBbkJBO0FBQUE7QUFDQTtBQURBO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQ0E7QUFEQTtBQUFBO0FBQUE7QUFDQTtBQURBO0FBQUE7QUFzQkE7QUF0QkE7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQXVCQTtBQUNBO0FBeEJBO0FBQUE7QUFDQTtBQURBO0FBeUJBO0FBekJBO0FBQUE7QUFDQTtBQURBO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQ0E7QUFEQTtBQUFBO0FBQUE7QUFDQTtBQURBO0FBQUE7QUE0QkE7QUE1QkE7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQTRCQTtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUFBO0FBQ0E7QUFDQTtBQUNBO0FBQ0E7QUFDQTtBQUFBO0FBQ0E7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFDQTtBQTFDQTtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUNBO0FBREE7QUFBQTtBQUFBO0FBQ0E7QUFEQTtBQUFBO0FBMkNBO0FBM0NBO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQ0E7QUFEQTtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQ0E7QUE0Q0E7QUFDQTtBQUNBO0FBQUE7QUFDQTtBQUNBO0FBQ0E7QUFsREE7QUFBQTtBQUFBO0FBQUE7QUFBQTtBQUFBO0FBQUE7QUFDQTtBQURBO0FBQUE7QUFBQTtBQUNBO0FBREE7QUFBQTtBQUFBO0FBVEEiLCJzb3VyY2VSb290IjoiIn0=\n//# sourceURL=webpack-internal:///./node_modules/cache-loader/dist/cjs.js?!./node_modules/babel-loader/lib/index.js!./node_modules/cache-loader/dist/cjs.js?!./node_modules/vue-loader/lib/index.js?!./src/views/LabMode.vue?vue&type=script&lang=js&\n");

/***/ })

})