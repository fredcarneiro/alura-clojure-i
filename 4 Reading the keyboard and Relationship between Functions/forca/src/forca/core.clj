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

(defn le-letra! [] (read-line)) ;; ! funções mutáveis, mudam de estado

(defn acertou? [chute palavra] (.contains palavra chute)) ;; .contains chamada a uma função do java

(defn avalia-chute [chute vidas palavra acertos]
	(if (acertou? chute palavra)
		(jogo vidas palavra (conj acertos chute))
		(jogo (dec vidas) palavra acertos)
	)
)

(defn jogo [vidas palavra acertos]
	(if (= vidas 0)
		(perdeu)
		(if (acertou-a-palavra-toda? palavra acertos) ;; acertou-a-palavra-toda boolean function
			(ganhou)
			(avalia-chute (le-letra!) vidas palavra acertos)
		)

	)
)

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
