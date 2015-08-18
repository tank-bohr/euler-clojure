(ns euler.core-test
  (:require [clojure.test :refer :all]
            [euler.core :refer :all]))

(deftest a-test
  (testing "dummy"
    (is (= 1 1))))

(deftest problem1-test
  (is (problem1 10) 23))

(deftest multiples-of-3-or-5-test
  (is (multiples-of-3-or-5 10) '(3 5 6 9)))

(deftest fibonacci-next-test
  (is (fibonacci-next '(1 1)) '(2 1 1))
  (is (fibonacci-next '(2 1 1)) '(3 2 1 1)))

(deftest fibonacci-test
  (is (fibonacci 10) '(8 5 3 2 1 1)))

(deftest prime?-test
  (is (prime? 1))
  (is (prime? 2))
  (is (prime? 3))
  (is (not (prime? 4)))
  (is (prime? 5))
  (is (not (prime? 6)))
  (is (prime? 17)))

(deftest max-prime-factor-test
  (is (max-prime-factor 13195) 29))
