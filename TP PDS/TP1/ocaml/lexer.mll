{
  open Lexing
  open Parser        (* The type token is defined in parser.ml *)

  type error = {
    character: char;
    line: int;
    pos: int;
  }

  exception Unexpected_character of error
}

let blanks    = [' ' '\t' '\n']

rule tokenize = parse
    (* skip new lines and update line count (useful for error location) *)
  | '\n'                        { let _ = new_line lexbuf in tokenize lexbuf }
    (* skip other blanks *)
  | blanks                      { tokenize lexbuf }


    (* … *)


    (* catch errors *)
  | _ as c                      { raise (Unexpected_character {
      character = c;
      line = lexbuf.lex_curr_p.pos_lnum;
      pos  = lexbuf.lex_curr_p.pos_cnum - lexbuf.lex_curr_p.pos_bol;
    })}
