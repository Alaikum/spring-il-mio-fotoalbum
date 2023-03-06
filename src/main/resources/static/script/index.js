console.log("index foto")
let axiosUrl="http://localhost:8080/api/foto"
listaFoto(axiosUrl)
let filter=""
function search(){
	let search=document.querySelector("#select__search").value
	let searchValue=document.querySelector("#value__search").value
	console.log(search,"valora: ",searchValue)
	filter=axiosUrl+"?"+search+"="+searchValue
	console.log(filter)
	document.querySelector('#lista').innerHTML=""
	listaFoto(filter)
	
}

function listaFoto(url){
    axios.get(url).then((res)=>{
        console.log(res.data)
        res.data.forEach(f => {
			
			if (f.visibile) {
				
				let textCat=""
				if(f.categorie.length >0){
					f.categorie.forEach(c => {
						textCat+=c.nome+" "
					});
				}else{
					textCat+="Nessuna categoria assegnata!" 
				}
				
				
				document.querySelector('#lista').innerHTML += `
				<div class="col">
				<div class="card ">
				<img src="${f.url}" class="card-img-top" alt="...">
				<div class="card-body">
				<h5 class="card-title">${f.titolo}</h5>
				<p class="card-text">
				Descrizione: <br> <i>${f.descrizione}</i>
							</p>
							<p class="card-text">
							Numero Commenti:  <i class="bg-info p-1">${f.commenti.length}</i>
							</p>
							<p class="card-text">
							Categorie: <i >${textCat}</i>
							
							</p>
							

							</p>
							</div>
							<div
							class="card-footer d-xl-flex justify-content-between  align-items-center">
							<small class="text-muted">Tag: ${f.tag}</small>  <a
                            href="/frontend/show?id=${f.id}"><small class="text-muted">Dettaglio:
							<i class="fa-solid fa-circle-info"></i></a></small>
							
							</div>
							</div>
							
							</div>
							`
							
						}else{
							console.log("foto con id"+f.id+" non visibile")
						}
						});
					}).catch((res)=>{
						console.log("not Ok",res)
					})
}