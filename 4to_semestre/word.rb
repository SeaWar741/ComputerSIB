word = "perro"
times = 0
letter = ""
election = 0
telection = 0
uword = ""
p "Adivina la palabra"
p "Tendras 5 oportunidades para adivinar la palabra"
while times < 5
		p "Elegir si deseas ver una pista o adivinar la palabra, solo tendras 2 pistas"
		election = gets.chomp
		if election.to_i == 1 && telection == 0
			puts "la primer letra es p"
			telection += 1
		elsif election.to_i == 1 && telection == 1
			puts "la ultima letra es o"
		elsif election.to_i == 0
			puts "ingresar la palabra"
			uword = gets.chomp
			if uword == word
				puts "Adivinaste la palabra! Bravo"
				times = 5
			else
				puts "te has equivocado :("
				times += 1
			end
		end
end
puts "El juego ha finalizado"



