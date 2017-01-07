(ns threact-runner.core
  (:require [cljs.spec :as spec]))

(defonce app-state (atom {:likes 0}))
(spec/def ::even? (spec/and integer? even?))

(defn test-spec
  []
  (spec/conform even? 1000))

(.log js/console "Hey ThReact? sup?!")
(.log js/console (test-spec))
