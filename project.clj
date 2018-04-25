(defproject demo "0.0.1"
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/clojurescript "1.10.238" :exclusions [org.apache.ant/ant]]]

  :plugins [[lein-cljsbuild "1.1.7" :exclusions [org.clojure/clojure]]]

  :clean-targets ^{:protect false} [:target-path
                                    "compiled"]

  :aliases {"dev" ["do" ["clean"] ["cljsbuild" "once" "first"]]
            "prod" ["do" ["clean"] ["with-profile" "prod" "cljsbuild" "once" "first"]]}

  :cljsbuild {:builds {:first {:source-paths ["src/first"]
                               :compiler {:output-to "compiled/first.js"
                                          :output-dir "compiled/first.out"
                                          :asset-path "compiled/first.out"
                                          :optimizations :none
                                          :target :nodejs
                                          :main demo.first}}}}

  :jvm-opts ["--add-modules" "java.xml.bind"]

  :profiles {:prod {:cljsbuild {:builds {:first {:compiler {:optimizations :simple
                                                            :source-map "compiled/first.js.map"}}}}}})
