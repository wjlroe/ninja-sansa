(defproject ninja-sansa "0.1.0-SNAPSHOT"
            :description "Boxes and numbers in a dashboard stylie"
            :url "github.com/wjlroe/ninja-sansa"
            :license {:name "Eclipse Public License"
                      :url "http://www.eclipse.org/legal/epl-v10.html"}
            :dependencies [[org.clojure/clojure "1.5.1"]
                           [compojure "1.1.5"]
                           ]
            ;; CLJ source code path
            :source-paths ["src/clj"]

            ;; lein-cljsbuild plugin to build a CLJS project
            :plugins [[lein-cljsbuild "0.3.0"]
                      [lein-ring "0.8.3"]]

            :ring {:handler ninja-sansa.core/handler}

            ;; cljsbuild options configuration
            :cljsbuild {:builds
                        [{;; CLJS source code path
                          :source-paths ["src/cljs"]

                          ;; Google Closure (CLS) options configuration
                          :compiler {;; CLS generated JS script filename
                                     :output-to "resources/public/js/sansa.js"

                                     ;; minimal JS optimization directive
                                     :optimizations :whitespace

                                     ;; generated JS code prettyfication
                                     :pretty-print true}}]}
            )
