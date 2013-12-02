{:namespaces
 ({:source-url
   "https://github.com/clojure/tools.analyzer/blob/ff8f49e0d536fac460f52381bc0c56b550e59bf7/src/main/clojure/clojure/tools/analyzer.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer/clojure.tools.analyzer-api.html",
   :name "clojure.tools.analyzer",
   :doc
   "Analyzer for clojure code, host agnostic.\n\nEntry point:\n* analyze\n\nPlatform implementers must provide dynamic bindings for:\n* macroexpand-1\n* create-var\n* parse\n\nSee clojure.tools.analyzer.core-test for an example on how to setup the analyzer."}
  {:source-url
   "https://github.com/clojure/tools.analyzer/blob/1ca506126fed4066354ab7626c8a2087c73830e9/src/main/clojure/clojure/tools/analyzer/passes.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer/clojure.tools.analyzer.passes-api.html",
   :name "clojure.tools.analyzer.passes",
   :doc "Utilities for passes handling and for AST walking/updating"}
  {:source-url
   "https://github.com/clojure/tools.analyzer/blob/44ef85900e499d990b6c78256c671f7ebe7811f3/src/main/clojure/clojure/tools/analyzer/passes/add_binding_atom.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer/clojure.tools.analyzer.passes.add-binding-atom-api.html",
   :name "clojure.tools.analyzer.passes.add-binding-atom",
   :doc nil}
  {:source-url
   "https://github.com/clojure/tools.analyzer/blob/a233673c91dd001ad01a678dcd2b5630254a3a3e/src/main/clojure/clojure/tools/analyzer/passes/collect.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer/clojure.tools.analyzer.passes.collect-api.html",
   :name "clojure.tools.analyzer.passes.collect",
   :doc nil}
  {:source-url
   "https://github.com/clojure/tools.analyzer/blob/0cf008c5ac5a343c58813d0c9f6b7951ef9347d1/src/main/clojure/clojure/tools/analyzer/passes/constant_lifter.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer/clojure.tools.analyzer.passes.constant-lifter-api.html",
   :name "clojure.tools.analyzer.passes.constant-lifter",
   :doc nil}
  {:source-url
   "https://github.com/clojure/tools.analyzer/blob/0cf008c5ac5a343c58813d0c9f6b7951ef9347d1/src/main/clojure/clojure/tools/analyzer/passes/elide_meta.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer/clojure.tools.analyzer.passes.elide-meta-api.html",
   :name "clojure.tools.analyzer.passes.elide-meta",
   :doc nil}
  {:source-url
   "https://github.com/clojure/tools.analyzer/blob/0cf008c5ac5a343c58813d0c9f6b7951ef9347d1/src/main/clojure/clojure/tools/analyzer/passes/source_info.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer/clojure.tools.analyzer.passes.source-info-api.html",
   :name "clojure.tools.analyzer.passes.source-info",
   :doc nil}
  {:source-url
   "https://github.com/clojure/tools.analyzer/blob/2cfa02ed7fe23f36c373c9ff0fa5eb8d77b48038/src/main/clojure/clojure/tools/analyzer/passes/warn_earmuff.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer/clojure.tools.analyzer.passes.warn-earmuff-api.html",
   :name "clojure.tools.analyzer.passes.warn-earmuff",
   :doc nil}
  {:source-url
   "https://github.com/clojure/tools.analyzer/blob/5441e5d916f664978fbd744c2f6209acb426155a/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer/clojure.tools.analyzer.utils-api.html",
   :name "clojure.tools.analyzer.utils",
   :doc nil}),
 :vars
 ({:file "src/main/clojure/clojure/tools/analyzer.clj",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/ff8f49e0d536fac460f52381bc0c56b550e59bf7/src/main/clojure/clojure/tools/analyzer.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/ff8f49e0d536fac460f52381bc0c56b550e59bf7/src/main/clojure/clojure/tools/analyzer.clj#L25",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer/-parse",
   :namespace "clojure.tools.analyzer",
   :line 25,
   :var-type "multimethod",
   :doc
   "Takes a form and an env map and dispatches on the head of the form, a special\nform.",
   :name "-parse"}
  {:arglists ([form {:keys [context], :as env}]),
   :name "analyze",
   :namespace "clojure.tools.analyzer",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/ff8f49e0d536fac460f52381bc0c56b550e59bf7/src/main/clojure/clojure/tools/analyzer.clj#L30",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/ff8f49e0d536fac460f52381bc0c56b550e59bf7/src/main/clojure/clojure/tools/analyzer.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer/analyze",
   :doc
   "Given a form to analyze and an environment, a map containing:\n* :locals     a map from binding symbol to AST of the binding value\n* :context    a keyword describing the form's context, one of:\n ** :return     the form is in return position\n ** :statement  the return value of the form is not needed\n ** :expr       everything else\n* :ns         a symbol representing the current namespace of the form to be\n              analyzed, must be present in the :namespaces map\n* :namespaces an atom containing a map from namespace symbol to namespace map,\n              the namespace map contains the following keys:\n ** :mappings   a map of mappings of the namespace, symbol to var\n ** :aliases    a map of the aliases of the namespace, symbol to symbol\n ** :ns         a symbol representing the namespace\nreturns an AST for that form.\n\nThe AST is a map that is *guaranteed* to have the following keys:\n* :op   a keyword describing the AST node\n* :form the form represented by the AST node\n* :env  the environment map of the AST node\n\nAdditionaly if the AST node contains sub-nodes, it is guaranteed to have:\n* :children a vector of the keys of the AST node mapping to the sub-nodes",
   :var-type "function",
   :line 30,
   :file "src/main/clojure/clojure/tools/analyzer.clj"}
  {:arglists ([env]),
   :name "analyze-in-env",
   :namespace "clojure.tools.analyzer",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/ff8f49e0d536fac460f52381bc0c56b550e59bf7/src/main/clojure/clojure/tools/analyzer.clj#L83",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/ff8f49e0d536fac460f52381bc0c56b550e59bf7/src/main/clojure/clojure/tools/analyzer.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer/analyze-in-env",
   :doc
   "Takes an env map and returns a function that analyzes a form in that env",
   :var-type "function",
   :line 83,
   :file "src/main/clojure/clojure/tools/analyzer.clj"}
  {:arglists ([sym env]),
   :name "create-var",
   :namespace "clojure.tools.analyzer",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/ff8f49e0d536fac460f52381bc0c56b550e59bf7/src/main/clojure/clojure/tools/analyzer.clj#L94",
   :dynamic true,
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/ff8f49e0d536fac460f52381bc0c56b550e59bf7/src/main/clojure/clojure/tools/analyzer.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer/create-var",
   :doc "Creates a var for sym and returns it",
   :var-type "function",
   :line 94,
   :file "src/main/clojure/clojure/tools/analyzer.clj"}
  {:arglists ([]),
   :name "empty-env",
   :namespace "clojure.tools.analyzer",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/ff8f49e0d536fac460f52381bc0c56b550e59bf7/src/main/clojure/clojure/tools/analyzer.clj#L72",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/ff8f49e0d536fac460f52381bc0c56b550e59bf7/src/main/clojure/clojure/tools/analyzer.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer/empty-env",
   :doc "Returns an empty env",
   :var-type "function",
   :line 72,
   :file "src/main/clojure/clojure/tools/analyzer.clj"}
  {:arglists ([form env]),
   :name "macroexpand",
   :namespace "clojure.tools.analyzer",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/ff8f49e0d536fac460f52381bc0c56b550e59bf7/src/main/clojure/clojure/tools/analyzer.clj#L174",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/ff8f49e0d536fac460f52381bc0c56b550e59bf7/src/main/clojure/clojure/tools/analyzer.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer/macroexpand",
   :doc
   "Repeatedly calls macroexpand-1 on form until it no longer\nrepresents a macro form, then returns it.",
   :var-type "function",
   :line 174,
   :file "src/main/clojure/clojure/tools/analyzer.clj"}
  {:arglists ([form env]),
   :name "macroexpand-1",
   :namespace "clojure.tools.analyzer",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/ff8f49e0d536fac460f52381bc0c56b550e59bf7/src/main/clojure/clojure/tools/analyzer.clj#L88",
   :dynamic true,
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/ff8f49e0d536fac460f52381bc0c56b550e59bf7/src/main/clojure/clojure/tools/analyzer.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer/macroexpand-1",
   :doc
   "If form represents a macro form, returns its expansion,\nelse returns form.",
   :var-type "function",
   :line 88,
   :file "src/main/clojure/clojure/tools/analyzer.clj"}
  {:arglists ([[op & args] env]),
   :name "parse",
   :namespace "clojure.tools.analyzer",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/ff8f49e0d536fac460f52381bc0c56b550e59bf7/src/main/clojure/clojure/tools/analyzer.clj#L99",
   :dynamic true,
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/ff8f49e0d536fac460f52381bc0c56b550e59bf7/src/main/clojure/clojure/tools/analyzer.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer/parse",
   :doc "Multimethod that dispatches on op, should default to -parse",
   :var-type "function",
   :line 99,
   :file "src/main/clojure/clojure/tools/analyzer.clj"}
  {:file "src/main/clojure/clojure/tools/analyzer.clj",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/ff8f49e0d536fac460f52381bc0c56b550e59bf7/src/main/clojure/clojure/tools/analyzer.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/ff8f49e0d536fac460f52381bc0c56b550e59bf7/src/main/clojure/clojure/tools/analyzer.clj#L168",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer/specials",
   :namespace "clojure.tools.analyzer",
   :line 168,
   :var-type "var",
   :doc "Set of special forms common to every clojure variant",
   :name "specials"}
  {:arglists ([ast]),
   :name "children",
   :namespace "clojure.tools.analyzer.passes",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/1ca506126fed4066354ab7626c8a2087c73830e9/src/main/clojure/clojure/tools/analyzer/passes.clj#L30",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/1ca506126fed4066354ab7626c8a2087c73830e9/src/main/clojure/clojure/tools/analyzer/passes.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.passes/children",
   :doc
   "Return a vector of the children expression of the AST node, if it has any.\nThe children expressions are kept in order and flattened so that the returning\nvector contains only nodes and not vectors of nodes.",
   :var-type "function",
   :line 30,
   :file "src/main/clojure/clojure/tools/analyzer/passes.clj"}
  {:arglists ([{:keys [children], :as ast}]),
   :name "children*",
   :namespace "clojure.tools.analyzer.passes",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/1ca506126fed4066354ab7626c8a2087c73830e9/src/main/clojure/clojure/tools/analyzer/passes.clj#L22",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/1ca506126fed4066354ab7626c8a2087c73830e9/src/main/clojure/clojure/tools/analyzer/passes.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.passes/children*",
   :doc
   "Return a vector of the children expression of the AST node, if it has any.\nThe returned vector returns the childrens in the order as they appear in the\n:children field of the AST, and may be either a node or a vector of nodes.",
   :var-type "function",
   :line 22,
   :file "src/main/clojure/clojure/tools/analyzer/passes.clj"}
  {:arglists ([& fns]),
   :name "cycling",
   :namespace "clojure.tools.analyzer.passes",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/1ca506126fed4066354ab7626c8a2087c73830e9/src/main/clojure/clojure/tools/analyzer/passes.clj#L12",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/1ca506126fed4066354ab7626c8a2087c73830e9/src/main/clojure/clojure/tools/analyzer/passes.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.passes/cycling",
   :doc
   "Combine the given passes in a single pass that will be repeatedly\napplied to the AST until applying it another time will have no effect",
   :var-type "function",
   :line 12,
   :file "src/main/clojure/clojure/tools/analyzer/passes.clj"}
  {:arglists ([ast f] [ast f reversed?]),
   :name "postwalk",
   :namespace "clojure.tools.analyzer.passes",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/1ca506126fed4066354ab7626c8a2087c73830e9/src/main/clojure/clojure/tools/analyzer/passes.clj#L67",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/1ca506126fed4066354ab7626c8a2087c73830e9/src/main/clojure/clojure/tools/analyzer/passes.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.passes/postwalk",
   :doc "Shortrand for (walk ast identity f reversed?)",
   :var-type "function",
   :line 67,
   :file "src/main/clojure/clojure/tools/analyzer/passes.clj"}
  {:arglists ([ast f]),
   :name "prewalk",
   :namespace "clojure.tools.analyzer.passes",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/1ca506126fed4066354ab7626c8a2087c73830e9/src/main/clojure/clojure/tools/analyzer/passes.clj#L62",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/1ca506126fed4066354ab7626c8a2087c73830e9/src/main/clojure/clojure/tools/analyzer/passes.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.passes/prewalk",
   :doc "Shortrand for (walk ast f identity)",
   :var-type "function",
   :line 62,
   :file "src/main/clojure/clojure/tools/analyzer/passes.clj"}
  {:arglists ([ast pre post] [ast pre post reversed?]),
   :name "walk",
   :namespace "clojure.tools.analyzer.passes",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/1ca506126fed4066354ab7626c8a2087c73830e9/src/main/clojure/clojure/tools/analyzer/passes.clj#L49",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/1ca506126fed4066354ab7626c8a2087c73830e9/src/main/clojure/clojure/tools/analyzer/passes.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.passes/walk",
   :doc
   "Walk the ast applying pre when entering the nodes, and post when exiting.\nIf reversed? is not-nil, pre and post will be applied starting from the last\nchildren of the AST node to the first one.",
   :var-type "function",
   :line 49,
   :file "src/main/clojure/clojure/tools/analyzer/passes.clj"}
  {:arglists ([ast]),
   :name "add-binding-atom",
   :namespace "clojure.tools.analyzer.passes.add-binding-atom",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/44ef85900e499d990b6c78256c671f7ebe7811f3/src/main/clojure/clojure/tools/analyzer/passes/add_binding_atom.clj#L30",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/44ef85900e499d990b6c78256c671f7ebe7811f3/src/main/clojure/clojure/tools/analyzer/passes/add_binding_atom.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.passes.add-binding-atom/add-binding-atom",
   :doc
   "Walks the AST and adds an atom-backed-map to every local binding,\nthe same atom will be shared between all occurences of that local.\n\nThe atom is put in the :atom field of the node.",
   :var-type "function",
   :line 30,
   :file
   "src/main/clojure/clojure/tools/analyzer/passes/add_binding_atom.clj"}
  {:arglists ([& what]),
   :name "collect",
   :namespace "clojure.tools.analyzer.passes.collect",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/a233673c91dd001ad01a678dcd2b5630254a3a3e/src/main/clojure/clojure/tools/analyzer/passes/collect.clj#L93",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/a233673c91dd001ad01a678dcd2b5630254a3a3e/src/main/clojure/clojure/tools/analyzer/passes/collect.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.passes.collect/collect",
   :doc
   "Takes a variable number of keywords, and returns a pass that\nif the AST node is one of :fn :deftype or :reify, collects the\nin the AST what specified.\n\nValid keywords describing what to collect are:\n* :constants     constant expressions\n* :closed-overs  closed over local bindings\n* :callsites     keyword and protocol callsites",
   :var-type "function",
   :line 93,
   :file "src/main/clojure/clojure/tools/analyzer/passes/collect.clj"}
  {:file
   "src/main/clojure/clojure/tools/analyzer/passes/constant_lifter.clj",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/0cf008c5ac5a343c58813d0c9f6b7951ef9347d1/src/main/clojure/clojure/tools/analyzer/passes/constant_lifter.clj",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/0cf008c5ac5a343c58813d0c9f6b7951ef9347d1/src/main/clojure/clojure/tools/analyzer/passes/constant_lifter.clj#L13",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.passes.constant-lifter/constant-lift",
   :namespace "clojure.tools.analyzer.passes.constant-lifter",
   :line 13,
   :var-type "multimethod",
   :doc
   "If op is :vector/:set/:map, and every item of the collection is a literal\nand the collection ha no metadata or if op is :var and the var has :const\nmetadata, transform the node to an equivalent :const node.",
   :name "constant-lift"}
  {:arglists ([ast]),
   :name "elide-meta",
   :namespace "clojure.tools.analyzer.passes.elide-meta",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/0cf008c5ac5a343c58813d0c9f6b7951ef9347d1/src/main/clojure/clojure/tools/analyzer/passes/elide_meta.clj#L52",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/0cf008c5ac5a343c58813d0c9f6b7951ef9347d1/src/main/clojure/clojure/tools/analyzer/passes/elide_meta.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.passes.elide-meta/elide-meta",
   :doc
   "If elides is not empty and the AST node contains metadata,\ndissoc all the keys in elides from the metadata.",
   :var-type "function",
   :line 52,
   :file
   "src/main/clojure/clojure/tools/analyzer/passes/elide_meta.clj"}
  {:name "elides",
   :namespace "clojure.tools.analyzer.passes.elide-meta",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/0cf008c5ac5a343c58813d0c9f6b7951ef9347d1/src/main/clojure/clojure/tools/analyzer/passes/elide_meta.clj#L11",
   :dynamic true,
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/0cf008c5ac5a343c58813d0c9f6b7951ef9347d1/src/main/clojure/clojure/tools/analyzer/passes/elide_meta.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.passes.elide-meta/elides",
   :doc "Set of map keys to elide from metadata.",
   :var-type "var",
   :line 11,
   :file
   "src/main/clojure/clojure/tools/analyzer/passes/elide_meta.clj"}
  {:arglists ([{:keys [form env], :as ast}]),
   :name "source-info",
   :namespace "clojure.tools.analyzer.passes.source-info",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/0cf008c5ac5a343c58813d0c9f6b7951ef9347d1/src/main/clojure/clojure/tools/analyzer/passes/source_info.clj#L12",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/0cf008c5ac5a343c58813d0c9f6b7951ef9347d1/src/main/clojure/clojure/tools/analyzer/passes/source_info.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.passes.source-info/source-info",
   :doc
   "Adds (when possible) :line, :column and :file info to the AST :env",
   :var-type "function",
   :line 12,
   :file
   "src/main/clojure/clojure/tools/analyzer/passes/source_info.clj"}
  {:arglists ([{:keys [op name var], :as ast}]),
   :name "warn-earmuff",
   :namespace "clojure.tools.analyzer.passes.warn-earmuff",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/2cfa02ed7fe23f36c373c9ff0fa5eb8d77b48038/src/main/clojure/clojure/tools/analyzer/passes/warn_earmuff.clj#L12",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/2cfa02ed7fe23f36c373c9ff0fa5eb8d77b48038/src/main/clojure/clojure/tools/analyzer/passes/warn_earmuff.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.passes.warn-earmuff/warn-earmuff",
   :doc
   "Prints a warning to *err* if the AST node is a :def node and the\nvar name contains earmuffs but the var is not marked dynamic",
   :var-type "function",
   :line 12,
   :file
   "src/main/clojure/clojure/tools/analyzer/passes/warn_earmuff.clj"}
  {:arglists ([form]),
   :name "classify",
   :namespace "clojure.tools.analyzer.utils",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/5441e5d916f664978fbd744c2f6209acb426155a/src/main/clojure/clojure/tools/analyzer/utils.clj#L37",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/5441e5d916f664978fbd744c2f6209acb426155a/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.utils/classify",
   :doc "Returns a keyword describing the form type",
   :var-type "function",
   :line 37,
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj"}
  {:arglists ([env ctx]),
   :name "ctx",
   :namespace "clojure.tools.analyzer.utils",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/5441e5d916f664978fbd744c2f6209acb426155a/src/main/clojure/clojure/tools/analyzer/utils.clj#L19",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/5441e5d916f664978fbd744c2f6209acb426155a/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.utils/ctx",
   :doc
   "Returns a copy of the passed environment with :context set to ctx",
   :var-type "function",
   :line 19,
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj"}
  {:arglists ([target f & args]),
   :name "update!",
   :namespace "clojure.tools.analyzer.utils",
   :source-url
   "https://github.com/clojure/tools.analyzer/blob/5441e5d916f664978fbd744c2f6209acb426155a/src/main/clojure/clojure/tools/analyzer/utils.clj#L14",
   :raw-source-url
   "https://github.com/clojure/tools.analyzer/raw/5441e5d916f664978fbd744c2f6209acb426155a/src/main/clojure/clojure/tools/analyzer/utils.clj",
   :wiki-url
   "http://clojure.github.com/tools.analyzer//clojure.tools.analyzer-api.html#clojure.tools.analyzer.utils/update!",
   :doc "Shortrand for (set! x (f x a0 .. an))",
   :var-type "macro",
   :line 14,
   :file "src/main/clojure/clojure/tools/analyzer/utils.clj"})}