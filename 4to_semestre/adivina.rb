word = "Perro"
times = 0
letter = ""
election = 0
telection = 0
uword = ""
p "Adivina la palabra"
p "Tendras 5 oportunidades para adivinar la palabra"
while times < 5
	p "Elegir si deseas ver una pista o adivinar la palabra, solo tendras 2 pistas"
	election = gets.chomp.to_i
	if election == 1 and telection == 0
		p "la primer letra es p"
	elsif election == 1 and telection == 1
		p "la ultima letra es o"
	elsif election == 0
		p "ingresar la palabra"
		uword = gets.chomp
		if uword == word
			p "Adivinaste la palabra! Bravo"
		else
			p "te has equivocado :("
			times ++
		end
	end
end



