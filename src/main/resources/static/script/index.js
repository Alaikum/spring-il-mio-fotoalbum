console.log("index foto")

listaFoto()

function listaFoto(){
    axios.get("http://localhost:8080/api/foto").then((res)=>{
        console.log(res.data)
        res.data.forEach(f => {
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
								Numero Commenti:  <i class="bg-info p-1">f.commenti.size</i>
							</p>
							<p class="card-text">
								Categorie: <i >- </i> <i>Nessuna Categoria Salvata </i>

							</p>
							<p class="card-text">
								Visibilità: <i class="fa-solid fa-thumbs-up"
									></i> <i class="fa-solid fa-thumbs-down"
									></i>

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
            
        });
    }).catch((res)=>{
        console.log("not Ok",res)
    })
}