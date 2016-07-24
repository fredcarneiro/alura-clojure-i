;; when you do a modification the REPL needs to be reloaded
;; solution-1: re-open lein repl
;; solution-2: (require '[forca.core :as forca] :reload)

(ns forca.core
  (:gen-class))


(def total-de-vidas 6)

;; call function: (perdeu)
;; call function: (forca.core/perdeu)
(defn perdeu [] (print "Você perdeu."))
(defn ganhou [] (print "Você ganhou."))
(defn letras-faltantes [palavra acertos] 
	(remove (fn [letra] (contains? acertos (str letra))) palavra) ;; remove da PALAVRA os ACERTOS
)
(defn acertou-a-palavra-toda? [palavra acertos] 
	(empty? (letras-faltantes palavra acertos))
)

;; (forca/jogo 5 "MELANCIA" #{"M" "A"}) ==> #{"M" "A"} set declaration (conjunto, não aceita valores repetidos)

;; (def conjunto #{"A" "M" "L"}) -> set def
;; #{"L" "M" "A"}
;; (contains? conjunto "L") -> contains
;; true
;; (contains? conjunto "Q")
;; false
;; (conj conjunto "X") -> add
;; #{"L" "M" "X" "A"}
;; conjunto
;; #{"L" "M" "A"}
;; (disj conjunto "X") -> remove
;; #{"L" "M" "A"}
;; conjunto
;; #{"L" "M" "A"}

;; (def nums [1 2 3 4]) == > list
;; [1 2 3 4]
;; (defn mult [x] (* x 2))
;; (mult 2)
;; 4
;; (map mult nums) ==> passa a função mult em todos os itens da lista
;; (2 4 6 8)
;; (map (fn [x] (* x 3)) nums)
;; (3 6 9 12)
;; (defn par [x] (= 0 (rem x 2))) ==> rem -> return the mod value
;; (remove par nums) ==> remover os numeros pares
;; (1 3)

(defn funcao-filter [x] 

	(filter (fn [x] (or (< x 2) (> x 4))) valores)

	)

(defn jogo [vidas palavra acertos]
	(if (= vidas 0)
		(perdeu)
		(if (acertou-a-palavra-toda? palavra acertos) ;; acertou-a-palavra-toda boolean function
			(ganhou)
			(print "Chuta, amigo!")
		)

	)
)

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
