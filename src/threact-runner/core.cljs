(ns threact-runner.core
  (:require [cljs.spec :as spec]
            [threact.core :as c]
            [threact.specs :as t]
            [threact.element.scene :as sc]
            [threact.element.camera :as cam]))

(defonce app-state (atom {:likes 0}))
(spec/def ::even? (spec/and integer? even?))

(defn test-spec-simple
  []
  (spec/conform even? 1000))

(def camera
  {:position [0 0 0] :rotation [0 0 0] :fov 90})

(def renderer
  {:size [250 250]})

(def scene
  {:camera camera :renderer renderer})

(defn threact-spec-valid?
  []
  (spec/valid? ::sc/scene scene))

(defn threact-spec-explain
  []
  (spec/explain ::sc/scene scene))

(defn a
  []
  (c/x-plus-y 2 2))

;(.log js/console (test-spec))
(.log js/console (threact-spec-valid?))
(.log js/console (str "Explain result: " (with-out-str (threact-spec-explain))))
