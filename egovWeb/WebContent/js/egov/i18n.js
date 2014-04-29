egov.dictionary={
	"firstName"	: {"en":"First Name: ", "fr":"Prenom: ", "rw": "Izina ry' idini: "},
	"lastName"	: {"en":"Last Name: ", "fr":"Nom de famille: ", "rw": "Izina ry' umuryango: "},
	"middleName"	: {"en":"Middle Name: ", "fr":"Autre Noms: ", "rw": "Andi mazina: "},
	"dateOfBirth": {"en":"Date of Birth: ", "fr":"Date de naissance: ", "rw": "Itariki y' amavuko: "},
	"placeOfBirth": {"en":"Place of Birth: ", "fr":"Place de naissance: ", "rw": "Aho yavukiye: "},
	"father":{"en":"Father: ", "fr":"Pere: ", "rw": "Ise: "},
	"mother":{"en":"Mother: ", "fr":"Mere: ", "rw": "Nyina: "},
	"citizenship":{"en":"Citizenship: ", "fr":"Citoyennete: ", "rw": "Ubwenegihugu: "},
	"sex": {"en":"Sex: ", "fr":"Sexe: ", "rw": "Igitsina: "},
	"occupation":{"en":"Occupation: ", "fr":"Occupation: ", "rw": "Umurimo: "},
	"identityPaper":{"en":"Identity Paper: ", "fr":"Piece d' Identite: ", "rw": "Icyangombwa: "},
	"identityNumber":{"en":"Number: ", "fr":"Numero: ", "rw": "Nimero: "},
	"identityType":{"en":"Type: ", "fr":"Type: ", "rw": "Ubwoko(icyiciro): "},
	"issuingCountry":{"en":"Issuing Country: ", "fr":"Pays d' Octroie: ", "rw": "Igihugu: "},
	"expiryDate":{"en":"Expiry Date: ", "fr":"Date d' Expiration: ", "rw": "Itariki kizarangiraho: "},
	"homeAddress":{"en":"Home Address: ", "fr":"Addresse a Domicile: ", "rw": "Aho atuye: "},
	"streetNumber":{"en":"Street Number: ", "fr":"Numero de la Rue: ", "rw": "Nimero yo ku muhanda: "},
	"streetName":{"en":"Street Name: ", "fr":"Nom de la Rue: ", "rw": "Izina ry' Umuhanda: "},
	"appartmentNumber":{"en":"Appartment number: ", "fr":"Numero d' appartement: ", "rw": "Nimero y' inzu: "},
	"zipCode":{"en":"Zip/Postal Code: ", "fr":"Code Postal/Zip: ", "rw": "Agasanduku k' Iposita cg Zip: "},
	"cell":{"en":"Cell: ", "fr":"Cellule: ", "rw": "Akagari: "},
	"district":{"en":"District: ", "fr":"District: ", "rw": "Umurenge: "},
	"province":{"en":"Province: ", "fr":"Province: ", "rw": "Intara: "},
	"workAddress": {"en":"Work Address: ", "fr":"Addresse de Travail: ", "rw": "Aho akorera: "},
    "email":{"en":"Email: ", "fr":"Courriel: ", "rw": "Email: "},
    "homePhone":{"en":"Home Phone: ", "fr":"Telephone a la Maison: ", "rw": "Telephone mu rugo: "},
    "workPhone":{"en":"Work Phone: ", "fr":"Telephone au Travail: ", "rw": "Telephone ku kazi: "},
    "mobilePhone":{"en":"Mobile Phone: ", "fr":"Telephone Mobile: ", "rw": "Telephone Mobile: "},
    "contactMethod":{"en":"Contact Method: ", "fr":"Moyen de Contact: ", "rw": "Uburyo twakugeraho: "}
}; 
  
egov.i18n = function(key){
	var pageLang = ($("html").attr("lang") == undefined) ? "en" : ($("html").attr("lang")); 
	var dictionaryValue  =  egov.dictionary[key];
	var i18nValue = dictionaryValue[pageLang]; 
	return i18nValue;
}; 