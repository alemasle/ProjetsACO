parser grammar TurtleParser;

options {
  language = Java;
  tokenVocab = TurtleLexer;
}

@header {
  package TP1;
}

document returns [ASD.Document out]
  : s=sujet EOF { $out = new ASD.Document($s.out); }
  ;

sujet returns [ASD.Document.Sujet out]]
	:	(entite predicat *)
	;

predicat:	(entite objet *);

objet:	objetTexte | objetEntite;

objetTexte:	texte;

objetEntite:	entite;

texte: ident ;

entite:	 ident ;

ident : ID;
