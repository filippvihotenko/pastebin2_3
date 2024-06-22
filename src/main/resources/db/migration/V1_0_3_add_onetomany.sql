ALTER TABLE Post
    ADD CONSTRAINT fk_sender_id
        FOREIGN KEY (sender_id) REFERENCES Person(uuid);