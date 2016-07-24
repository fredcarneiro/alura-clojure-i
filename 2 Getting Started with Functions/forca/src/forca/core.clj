;; when you do a modification the REPL needs to be reloaded
;; solution-1: re-open lein repl
;; solution-2: (require '[forca.core :as forca] :reload)

(ns forca.core
  (:gen-class))


(def total-de-vidas 6)

;; call function: (perdeu)
;; call function: (forca.core/perdeu)
(defn perdeu [] (print "Você perdeu."))

(defn jogo [vidas]
	;; not= (not equal)
	(if (= vidas 0)
		;; TRUE
		(perdeu)
		;; FALSE
		(do ;; funtion to do a series of commands
			(print vidas) ;;(jogo (- vidas 1))
			(jogo (dec vidas)) ;; - 1
		)

	)
)

;; EXERCICIO FIBONACCI
(defn fib [x]
	(if (= x 0)
		0
	)

	(if (= x 1)
		1
	)

	(if (>= x 2)
		
		(+ 
			(fib (- x 1)) 
			(fib (- x 2))
		)

	)
)

;; EXERCICIO FIBONACCI RESPOSTA
(defn fib2 [x]
	(if (= x 0) 0
	(if (= x 1)	1
	(+ (fib (- x 1)) (fib (- x 2)))
	))
)

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
