(defproject ont-app/vocabulary "0.1.5"
  :description "Utilities to map between namespaced keywords and URIs, and support language-tagged strings."
  :url "https://github.com/ont-app/vocabulary"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :min-lein-version "2.7.1"
  :plugins [
            [lein-cljsbuild "1.1.7"
             :exclusions [[org.clojure/clojure]]]
            [lein-codox "0.10.6"]
            [lein-doo "0.1.11"]
            ]
  ;; CLJC
  :source-paths ["src"]
  :resource-paths ["resources"]
  :target-path "target/%s"
  :test-paths ["test"]
  ;; CLJS
  :cljsbuild
  {:test-commands {"test" ["lein" "doo" "node" "test" "once"]}
   :resource-paths ["resources"]
   :builds
   {
    :test {:source-paths ["src" "test"]
           :compiler {:output-to "resources/test/compiled.js"
                      :output-dir "resources/test/js/compiled/out"
                      ;; entry point for doo-runner:
                      :main ont-app.vocabulary.doo
                      :target :nodejs
                      :optimizations :advanced ;; none
                      :warnings {:bad-method-signature false}
                      }}
   }} ;; cljsbuild
  :codox {:output-path "doc"}
  :profiles
  {:dev {:dependencies
         [;; deps :tree disambiguation...
          ;; <none>
          ;; clojure
          [org.clojure/clojure "1.10.3"]
          [org.clojure/clojurescript "1.10.896"]
          [lein-doo "0.1.11"]
          ]}}
  :clean-targets
  ^{:protect false}
  ["resources/dev/js/compiled"
   "resources/test"
   :target-path
   ])
