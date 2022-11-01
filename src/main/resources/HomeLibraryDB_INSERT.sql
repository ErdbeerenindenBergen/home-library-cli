TRANSACTION BLOCK;

INSERT INTO public.book(
	isbn, title, subtitle, publishers, publish_date, number_of_pages)
	VALUES (9780631188919, 'What Is Nature?', 'Culture, Politics and the Non-Human', 'Blackwell Publishers', 'October 1995', 289);

INSERT INTO public.author(
	author_id, name)
	VALUES ('OL590610A', 'Kate Soper');

INSERT INTO public.book_author(
	isbn, author_id)
	VALUES (9780631188919, 'OL590610A');
	
COMMIT;