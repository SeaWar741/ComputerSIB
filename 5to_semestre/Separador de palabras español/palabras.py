file = open("palabras.txt","r+")
filepath = "palabras.txt"
words=[]
f = open('palabras.txt')
lines = f.readline()

for line in f.readlines():
    text = line.lower()
    if text.endswith('\n'):
            text = text[:-1]
    if text not in words:
        words.append(text)
f.close()
print(words)

endfile = open("sustantivos.txt","w")
for x in words:
    endfile.write(x+'\n')
endfile.close()

print(len(words))
