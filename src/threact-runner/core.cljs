(ns threact-runner.core
  (:require [cljs.spec :as spec]
            [threact.core :as t]))

(defonce app-state (atom {:likes 0}))
(spec/def ::even? (spec/and integer? even?))

(defn test-spec
  []
  (spec/conform even? 1000))

(defn a
  []
  (t/x-plus-y 2 2))


(.log js/console "Hey ThReact? sup?!")
(.log js/console (test-spec))
(.log js/console (a))
