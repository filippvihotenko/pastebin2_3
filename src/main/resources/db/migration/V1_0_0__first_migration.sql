CREATE schema if not exists pastebin;

CREATE TABLE Post (
                      post_Id UUID PRIMARY KEY,
                      sender_Id UUID NOT NULL,
                      timestamp TIMESTAMPTZ NOT NULL DEFAULT CURRENT_TIMESTAMP,
                      cathegory VARCHAR(255) NOT NULL ,
                      message VARCHAR(1000) NOT NULL ,
                      paste_exposure VARCHAR(255) NOT NULL,
                      paste_expiration VARCHAR(255) NOT NULL
);
CREATE TABLE Person (
        uuid UUID PRIMARY KEY,
        username VARCHAR(255) UNIQUE NOT NULL,
        password VARCHAR(255) NOT NULL,
        role VARCHAR(255) NOT NULL
);

CREATE OR REPLACE FUNCTION set_timestamp()
    RETURNS TRIGGER AS $$
BEGIN
    NEW.timestamp = now();
RETURN new;
END;
$$ LANGUAGE plpgsql;

CREATE TRIGGER set_timestamp
    BEFORE INSERT ON Post
    FOR EACH ROW
    EXECUTE FUNCTION set_timestamp();