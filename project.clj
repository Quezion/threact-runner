(defproject threact-runner "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.9.0-alpha14"]
                 [org.clojure/clojurescript "1.9.229"]
                 [threact "0.1.0-SNAPSHOT"]

                 ;; Per Threact project.clj, you must include this dependency
                 [cljsjs/three "0.0.76-0"]]                 
  :plugins [[lein-figwheel "0.5.8"]]
  :clean-targets [:target-path "out"]
  :cljsbuild {
              :builds [{:id "dev"
                        :source-paths ["src" "checkouts/threact/src"]
                        :figwheel true
                        :compiler {:main "threact-runner.core"}
                        }]
              })
