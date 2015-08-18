(ns euler.core)

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(defn multiples?
  [n x]
  (== 0 (mod n x)))

(defn multiples-of-3-or-5
  [edge]
  (filter
    #(or
      (multiples? % 3)
      (multiples? % 5))
    (range 1 edge)))

(defn fibonacci-next
  [s]
  (cons (reduce + (take 2 s)) s))

(defn fibonacci
  ([edge]
    (fibonacci edge '(1 1)))
  ([edge acc]
    (if (< edge (first acc))
      (rest acc)
      (recur edge (fibonacci-next acc)))))

(defn prime?
  [n]
  (empty? (filter
    #(multiples? n %)
    (range 2 (- n 1)))))

(defn factors
  [n]
  (filter
    #(multiples? n %)
    (range 2 (quot n 2))))

(defn max-prime-factor
  [n]
  (first (filter
    prime?
    (map
      #(quot n %)
      (factors n)))))

(def problem1
  "Find the sum of all the multiples of 3 or 5 below x"
  (reduce + (multiples-of-3-or-5 1000)))

(def problem2
  "Even Fibonacci numbers"
  (reduce + (filter even? (fibonacci 4000000))))

(def problem3
  "Largest prime factor"
  (max-prime-factor 600851475143))
