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

(defn max-prime-factor-begin-from
  [n]
  (let [m (quot n 2)]
    (if
      (even? m)
      (+ m 1)
      m)))

(defn max-prime-factor
  [n]
  (first (filter
    #(and
      (multiples? n %)
      (prime? %))
    (range (max-prime-factor-begin-from n) 1 -2))))

(defn problem1
  "Find the sum of all the multiples of 3 or 5 below x"
  [x]
  (reduce + (multiples-of-3-or-5 x)))

(defn problem2
  "Even Fibonacci numbers"
  [x]
  (reduce + (filter even? (fibonacci x))))

(def problem3 max-prime-factor)
