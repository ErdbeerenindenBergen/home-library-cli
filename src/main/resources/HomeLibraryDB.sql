BEGIN TRANSACTION;

DROP TABLE IF EXISTS book, author, book_author;

-- Table: book

CREATE TABLE IF NOT EXISTS book
(
    isbn bigint NOT NULL,
    title character varying NOT NULL,
    subtitle character varying,
    publishers character varying,
    publish_date character varying,
    number_of_pages integer,
    CONSTRAINT book_pkey PRIMARY KEY (isbn)
);

ALTER TABLE IF EXISTS book
    OWNER to postgres;
	
-- Table: author

CREATE TABLE IF NOT EXISTS author
(
    author_id character varying NOT NULL,
    name character varying NOT NULL,
    CONSTRAINT author_pkey PRIMARY KEY (author_id)
);

ALTER TABLE IF EXISTS author
    OWNER to postgres;
	
-- Table: book_author

CREATE TABLE IF NOT EXISTS book_author
(
    isbn bigint NOT NULL,
    author_id character NOT NULL,
    CONSTRAINT book_author_pkey PRIMARY KEY (author_id, isbn),
    CONSTRAINT fk_book_author_author_id_author_author_id FOREIGN KEY (author_id) REFERENCES author (author_id),
    CONSTRAINT fk_book_author_isbn_book_isbn FOREIGN KEY (isbn) REFERENCES book (isbn)
);

ALTER TABLE IF EXISTS book_author
    OWNER to postgres;
-- Index: fki_fk_book_author_author_id_author_author_id

DROP INDEX IF EXISTS fki_fk_book_author_author_id_author_author_id;

CREATE INDEX IF NOT EXISTS fki_fk_book_author_author_id_author_author_id
    ON book_author USING btree
    (author_id COLLATE pg_catalog."default" ASC NULLS LAST)
    TABLESPACE pg_default;
	
-- Index: fki_fk_book_author_isbn_book_isbn

DROP INDEX IF EXISTS fki_fk_book_author_isbn_book_isbn;

CREATE INDEX IF NOT EXISTS fki_fk_book_author_isbn_book_isbn
    ON book_author USING btree
    (isbn ASC NULLS LAST)
    TABLESPACE pg_default;

COMMIT;