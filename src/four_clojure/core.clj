(ns four-clojure.core
  (:gen-class)
  (:require [clojure.set :as s]))

(def funcs
  {
   :55
   (fn count-occurrences [xs]
     (apply hash-map (apply concat
                            (map #(vector (first %) (count (last %)))
                                 (group-by identity xs)))))
   :56
   (fn my-distinct [xs]
     (reduce (fn [acc x]
               (if (some (conj #{} x) acc)
                 acc
                 (conj acc x))) 
             [] xs))

   :57
   (fn my-comp [& funcs]
     (fn [& args]
       (let [rfuncs  (rest (reverse funcs))
             r (apply (first (reverse funcs)) args)]
         (loop [[f & frest] rfuncs
                res r]
           (if (empty? frest)
             (f res)
             (recur frest (f res)))))))

   :58
   (fn my-juxt [& funcs] 
     (fn [& args] 
       (map #(apply % args) funcs)))

   :60
   (fn my-reductions 
     ([f [init & coll]]
      (my-reductions f init coll))
     ([f init coll]
      (take-while #(not (nil? %))
                  (map first           
                       (iterate                  
                         (fn [[acc xs]]           
                           (if (nil? xs) 
                             [nil nil] 
                             (let [[x & xss] xs]
                               [(f acc x) xss])))
                         [init coll])))))

   :62
   (fn my-iterate [f x]
     (lazy-seq (cons x (my-iterate f (f x)))))

   :63
   (fn group-seq [f xs]
     (reduce (fn [acc x] 
               (let [res (f x)]
                 (if (contains? acc res)
                   (assoc acc res (conj (get acc res) x))
                   (assoc acc res (conj [] x))
                 )))
             {} xs))
   })

(defn -main
  "[p & args] Tests the solution to the requested four-clojure problem 
  (specified by problem number) using the provided arguments."
  [p & args]
  (let [f ((keyword (str p)) funcs)]
    (apply f args))
  )        
