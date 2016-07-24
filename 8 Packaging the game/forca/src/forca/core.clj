;; when you do a modification the REPL needs to be reloaded
;; solution-1: re-open lein repl
;; solution-2: (require '[forca.core :as forca] :reload)

;; (def carros [50000.0, 60000.0])
;; (map (fn [x] (* x 2)) carros)
;; (100000.0 120000.0)
;; (reduce (fn [acc n] (+ acc n)) carros) -> retorna apenas um valor. acc-> acumulador. n-> cada valor da lista carros
;; 110000.0
;; (->> carros (map (fn [x] (* x 2))) (reduce (fn [acc n]) (+ acc n))) -> primeiro aplicou o MAP e DEPOIS o reduce
;; (->> carros (map (fn [x] (* x 2))) (map (fn [x] (* x 3))) (reduce (fn [acc n]) (+ acc n)))
;; ->> processamento de listas em sequencia
;; 220000.0

;; lein uberjar -> passa o programa para java

(ns forca.core
  (:gen-class))


(def total-de-vidas 6)
(def palavra-secreta "MELANCIA")

;; call function: (perdeu)
;; call function: (forca.core/perdeu)
(defn perdeu [] (println "Você perdeu."))
(defn ganhou [] (println "Você ganhou."))

(defn letras-faltantes [palavra acertos] 
	(remove (fn [letra] (contains? acertos (str letra))) palavra)) ;; remove da PALAVRA os ACERTOS

(defn acertou-a-palavra-toda? [palavra acertos] 
	(empty? (letras-faltantes palavra acertos)))

(defn le-letra! [] (read-line)) ;; ! funções mutáveis, mudam de estado

(defn acertou? [chute palavra] (.contains palavra chute)) ;; .contains chamada a uma função do java

(defn imprimi-forca [vidas palavra acertos]
	(println "Vidas " vidas)
	;; map é uma lazy function e só será executada na hora que precisa ser executada. Só quando alguém for usar o resultado dela.
	;; doseq -> loop // (seq palavra) => quebra a palavra em uma lista de char e vai chamar cada elemento de letra
	(doseq [letra (seq palavra)] 
		(if (contains? acertos (str letra)) 
			(print letra " ") 
			(print "_" " ")))
		(println))

(defn jogo [vidas palavra acertos]
	(imprimi-forca vidas palavra acertos)
	(cond ;; IF COM VARIOS ELSES
		(= vidas 0) (perdeu)
		(acertou-a-palavra-toda? palavra acertos) (ganhou)
		:else
		(let [chute (le-letra!)]
			(if (acertou? chute palavra)
				(do
					(println "Acertou a letra!")
					(recur vidas palavra (conj acertos chute))) ;; recursão de cauda
				(do
					(println "Errou a letra! Perdeu vida.")
					(recur (dec vidas) palavra acertos)))))) ;; recursão de cauda
				

(defn comeca-o-jogo [] (jogo total-de-vidas palavra-secreta #{}))

(defn -main [& args] (comeca-o-jogo))

