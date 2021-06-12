import React from "react";
import { Button, Checkbox, Form, Container } from "semantic-ui-react";

export default function SignUpJobSeeker() {
    return (
        <div>
            <Container>
                <Form
                    className="sign-up-form"
                    style={{
                        width: "30rem",
                    }}
                >
                    <Form.Field>
                        <input placeholder="Ad" />
                    </Form.Field>
                    <Form.Field>
                        <input placeholder="Soyad" />
                    </Form.Field>
                    <Form.Field>
                        <input placeholder="Vatandaşlık Numarası" />
                    </Form.Field>
                    <Form.Field>
                        <input placeholder="E-Posta" />
                    </Form.Field>
                    <Form.Field>
                        <input type="password" placeholder="Parola" />
                    </Form.Field>
                    <Form.Field>
                        <input type="password" placeholder="Parola Tekrar" />
                    </Form.Field>
                    <Form.Field>
                        <Checkbox label="I agree to the Terms and Conditions" />
                    </Form.Field>
                    <Button floated="right" type="submit">
                        Üye Ol
                    </Button>
                </Form>
            </Container>
        </div>
    );
}
