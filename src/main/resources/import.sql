INSERT INTO fotoalbum.foto (titolo,descrizione,url,tag,visibile) VALUES ('Foto1','Bella foto1','https://picsum.photos/1200','#foto1',1);
INSERT INTO fotoalbum.foto (titolo,descrizione,url,tag,visibile) VALUES ('Foto2','Bella foto2','https://picsum.photos/1200','#foto2',0);
INSERT INTO fotoalbum.foto (titolo,descrizione,url,tag,visibile) VALUES ('Foto3','Bella foto3','https://picsum.photos/1200','#foto3',1);
INSERT INTO fotoalbum.foto (titolo,descrizione,url,tag,visibile) VALUES ('Foto4','Bella foto4','https://picsum.photos/1200','#foto4',0);
INSERT INTO fotoalbum.foto (titolo,descrizione,url,tag,visibile) VALUES ('Foto5','Bella foto5','https://picsum.photos/1200','#foto5',1);
INSERT INTO fotoalbum.foto (titolo,descrizione,url,tag,visibile) VALUES ('Foto6','Bella foto6','https://picsum.photos/1200','#foto6',0);
INSERT INTO fotoalbum.foto (titolo,descrizione,url,tag,visibile) VALUES ('Foto7','Bella foto7','https://picsum.photos/1200','#foto7',1);
INSERT INTO fotoalbum.foto (titolo,descrizione,url,tag,visibile) VALUES ('Foto8','Bella foto8','https://picsum.photos/1200','#foto8',0);
INSERT INTO fotoalbum.foto (titolo,descrizione,url,tag,visibile) VALUES ('Foto9','Bella foto9','https://picsum.photos/1200','#foto9',1);
INSERT INTO fotoalbum.foto (titolo,descrizione,url,tag,visibile) VALUES ('Foto10','Bella foto10','https://picsum.photos/1200','#foto10',0);

INSERT INTO fotoalbum.categoria (nome) VALUES ('categoria-1');
INSERT INTO fotoalbum.categoria (nome) VALUES ('categoria-2');

INSERT INTO fotoalbum.foto_categorie (foto_id,categorie_id) VALUES (1,1);
INSERT INTO fotoalbum.foto_categorie (foto_id,categorie_id) VALUES (1,2);
INSERT INTO fotoalbum.foto_categorie (foto_id,categorie_id) VALUES (2,1);

INSERT INTO fotoalbum.commento (descrizione,nome,foto_id) VALUES ('Una foto molto bella complimenti-1','Utente Reale-A',1);
INSERT INTO fotoalbum.commento (descrizione,nome,foto_id) VALUES ('Una foto molto bella complimenti-1-bis','Utente Reale-B',1);
INSERT INTO fotoalbum.commento (descrizione,nome,foto_id) VALUES ('Una foto molto bella complimenti-2','Utente Reale-C',2);