package TP1;

import java.nio.file.Paths;
import java.util.*;

import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class Main {

	public static String test() {
		// les entités
		ASD.Document.Entite ent = new ASD.Document.Entite("poly117");
		ASD.Document.Entite type = new ASD.Document.Entite("type");
		ASD.Document.Entite poly = new ASD.Document.Entite("poly");
		ASD.Document.Entite auteur = new ASD.Document.Entite("auteur");
		ASD.Document.Entite ridoux = new ASD.Document.Entite("Ridoux");
		ASD.Document.Entite ferre = new ASD.Document.Entite("Ferre");
		ASD.Document.Entite titre = new ASD.Document.Entite("titre");
		ASD.Document.Entite personne = new ASD.Document.Entite("personne");
		ASD.Document.Entite professeur = new ASD.Document.Entite("professeur");

		// les textes
		ASD.Document.Texte compilation = new ASD.Document.Texte("Compilation");

		// les objet Entités
		ASD.Document.ObjetEntite opoly = new ASD.Document.ObjetEntite(poly);
		ASD.Document.ObjetEntite oridoux = new ASD.Document.ObjetEntite(ridoux);
		ASD.Document.ObjetEntite oferre = new ASD.Document.ObjetEntite(ferre);
		ASD.Document.ObjetEntite opersonne = new ASD.Document.ObjetEntite(personne);
		ASD.Document.ObjetEntite oprofesseur = new ASD.Document.ObjetEntite(professeur);
		// les objet Textes
		ASD.Document.ObjetTexte ocompilation = new ASD.Document.ObjetTexte(compilation);

		// liste des objets
		List<ASD.Document.Objet> lo1 = new ArrayList<ASD.Document.Objet>();
		lo1.add(opoly);

		List<ASD.Document.Objet> lo2 = new ArrayList<ASD.Document.Objet>();
		lo2.add(oridoux);
		lo2.add(oferre);

		List<ASD.Document.Objet> lo3 = new ArrayList<ASD.Document.Objet>();
		lo3.add(ocompilation);

		List<ASD.Document.Objet> lo4 = new ArrayList<ASD.Document.Objet>();
		lo4.add(opersonne);
		lo4.add(oprofesseur);

		// les predicats
		ASD.Document.Predicat ptype = new ASD.Document.Predicat(type, lo1);
		ASD.Document.Predicat pauteur = new ASD.Document.Predicat(auteur, lo2);
		ASD.Document.Predicat ptitre = new ASD.Document.Predicat(titre, lo3);
		ASD.Document.Predicat ptype2 = new ASD.Document.Predicat(type, lo4);

		// liste des predicats
		List<ASD.Document.Predicat> lpPoly117 = new ArrayList<ASD.Document.Predicat>();
		lpPoly117.add(ptype);
		lpPoly117.add(pauteur);
		lpPoly117.add(ptitre);

		List<ASD.Document.Predicat> lpRidoux = new ArrayList<ASD.Document.Predicat>();
		lpRidoux.add(ptype2);

		// premier exemple avec poly117
		ASD.Document.Sujet sPoly117 = new ASD.Document.Sujet(ent, lpPoly117);
		// deuxieme exemple avec ridoux
		ASD.Document.Sujet sRidoux = new ASD.Document.Sujet(ridoux, lpRidoux);

		List<ASD.Document.Sujet> ls = new ArrayList<ASD.Document.Sujet>();
		ls.add(sPoly117);
		ls.add(sRidoux);

		ASD.Document ast1 = new ASD.Document(ls);

		return ast1.toNtriples();
	}

	public static void main(String[] args) {
		// Use with a manually made AST

		System.out.println(test());

		// Use with lexer and parser

		try {
			// Set input
			CharStream input;
			if (args.length == 0) {
				// From standard input
				input = CharStreams.fromStream(System.in);
			} else {
				// From file set in first argument
				input = CharStreams.fromPath(Paths.get(args[0]));
			}

			// Instantiate Lexer
			TurtleLexer lexer = new TurtleLexer(input);
			CommonTokenStream tokens = new CommonTokenStream(lexer);

			// Instantiate Parser
			TurtleParser parser = new TurtleParser(tokens);

			// Parse
			ASD.Document ast = parser.document().out;

			// Print as Ntriples
			System.out.println(ast.toNtriples());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
