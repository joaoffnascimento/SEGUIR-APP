import csv, json, requests, time

arquivo = open("02.csv")

linhas = csv.reader(arquivo)

i = 0
for linha in linhas:
	time.sleep(5)
	i += 1
	arr = linha[0].split(";")
	localizacao = {"veiculoId":"AKXFSGFF",
	"latitude":arr [0],
	"longitude":arr [1],
	"velocidade":arr [2],
	"dataHora":arr [3]}
	response = requests.post("http://localhost:8080/rest/localizacao/veiculo/enviar", json=localizacao)
	print (response.status_code)
