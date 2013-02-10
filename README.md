Le défi consiste à écrire un moteur de template qui prend une chaîne templatisée
et une liste de clés-valeurs. Par exemple avec "Bonjour {$name}" et le mapping
name => Bernard, la chaîne "Bonjour Bernard" est produite.

D'autres exemples :

firstName => Bernard
lastName  => Dupont
"Hello {$firstName} ${lastName}" 
Donne "Hello Bernard Dupont"

S'il n'y pas la clé correspondante on doit jeter une exception

On doit gérer des expressions imbriquées :
name => Bernard
"Hello ${{$name}}"
Donne "Hello ${Bernard}"

Bonus : Continuer l'évaluation tant qu'il y a des expressions à évaluer
name => Bernard
Bernard => Dr. Bernard Le Touillec
"Hello ${{$name}}"
Donne "Hello Dr. Bernard Le Touillec"
  