(ns threact-runner.core
  (:require [cljs.spec :as s]
            [threact.core :as c]
            [threact.element.camera :as cam]
            [cljsjs.three]))

(defn construct-renderer
  "Constructs a default THREE WebGLRenderer and returns it."
  [width height]
  (let [renderer (js/THREE.WebGLRenderer.)]
    (.setSize renderer width height)
    renderer))

(defn append-renderer-dom
  "Appends a renderer to a DOM node. Should be refactored to specify DOM node."
  [renderer3]
  (.appendChild (.-body js/document) (.-domElement renderer3)))


(def camera
  {:position [0 0 0] :rotation [0 0 0] :fov 90})

(def renderer
  {:size [250 250]})

(def cube-model
  {:position [0 1 0] :rotation [1 0 0]})

(def basic-scene
  {:camera camera
   :renderer renderer
   :models {:cube1 cube-model}})

(defonce app-state
  (atom {:root-dom-node (.-body js/document)
         :scene basic-scene}))

(defn print-result
  [name spec x]
  (.log js/console (str "=== Spec-Test BEGIN: " name " ==="))
  (let [valid? (s/valid? spec x)]
    (.log js/console (str "Valid? : " valid?))
    (when-not valid? (->> (with-out-str (s/explain spec x))
                          (.log js/console))))
  (.log js/console (str "+++ Spec-Test END: " name " +++")))
  
(print-result "Basic-Scene" ::c/scene basic-scene)
;(append-renderer-dom (construct-renderer 400 400))

