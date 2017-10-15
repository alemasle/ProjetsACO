package TP1;

import java.util.Iterator;
import java.util.List;

public class ASD {
	public static class Document {

		List<Sujet> ls;

		public Document(List<Sujet> ls) {
			this.ls = ls;
		}

		public static class Sujet {
			Entite e;
			List<Predicat> lp;

			public Sujet(Entite e, List<Predicat> lp) {
				this.e = e;
				this.lp = lp;
			}

			public String toNtriples() {
				String str = "";

				for (Predicat p : lp) {
					str = str + p.toNtriples(e);
				}

				return str;
			}

		}

		public static class Predicat {

			Entite e;
			List<Objet> lo;

			public Predicat(Entite e, List<Objet> lo) {
				this.e = e;
				this.lo = lo;
			}

			public String toNtriples(Entite e1) {
				String str = "";

				for (Objet o : lo) {
					str = str + e1.toNtriples() + " " + o.toNtriples(e) + "\n";
				}

				return str;
			}

		}

		abstract static class Objet {

			abstract String toNtriples(Entite e1);

		}

		public static class ObjetEntite extends Objet {
			Entite e;

			public ObjetEntite(Entite e) {
				this.e = e;
			}

			public String toNtriples(Entite e1) {
				return e1.toNtriples() + " " + e.toNtriples() + " .";
			}

		}

		public static class ObjetTexte extends Objet {
			Texte t;

			public ObjetTexte(Texte t) {
				this.t = t;

			}

			public String toNtriples(Entite e1) {
				return e1.toNtriples() + " " + t.toNtriples() + " .";
			}

		}

		public static class Entite {

			String s;

			public Entite(String s) {
				this.s = s;
			}

			public String toNtriples() {
				return "<" + s + ">";
			}
		}

		public static class Texte {

			String s;

			public Texte(String s) {
				this.s = s;
			}

			public String toNtriples() {
				return "\"" + s + "\"";
			}
		}

		public String toNtriples() {
			String str = "";

			for (Sujet s : ls) {
				str = str + s.toNtriples();
			}
			return str;

		}

	}

}
