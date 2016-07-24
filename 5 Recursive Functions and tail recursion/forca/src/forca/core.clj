;; when you do a modification the REPL needs to be reloaded
;; solution-1: re-open lein repl
;; solution-2: (require '[forca.core :as forca] :reload)

(ns forca.core
  (:gen-class))


(def total-de-vidas 6)

;; call function: (perdeu)
;; call function: (forca.core/perdeu)
(defn perdeu [] (println "Você perdeu."))
(defn ganhou [] (println "Você ganhou."))

(defn letras-faltantes [palavra acertos] 
	(remove (fn [letra] (contains? acertos (str letra))) palavra) ;; remove da PALAVRA os ACERTOS
)

(defn acertou-a-palavra-toda? [palavra acertos] 
	(empty? (letras-faltantes palavra acertos))
)

(defn le-letra! [] (read-line)) ;; ! funções mutáveis, mudam de estado

(defn acertou? [chute palavra] (.contains palavra chute)) ;; .contains chamada a uma função do java

;; se a ultima linha chama a própria função entao o compilador nao deixa gerar o problema de empilhamento
;; recursão de cauda

(defn jogo [vidas palavra acertos]
	(cond ;; IF COM VARIOS ELSES
		(= vidas 0) (perdeu)
		(acertou-a-palavra-toda? palavra acertos) (ganhou)
		:else
		(let [chute (read-line!)]
			(if (acertou? chute palavra)
				(do
					(println "Acertou a letra!")
					(recur vidas palavra (conj acertos chute))) ;; recursão de cauda
				(do
					(println "Errou a letra! Perdeu vida.")
					(recur (dec vidas) palavra acertos)))))) ;; recursão de cauda
				

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
