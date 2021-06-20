import React from "react";
import { Button, Container } from "semantic-ui-react";
import { Link } from "react-router-dom";
import { Formik, Form } from "formik";
import * as Yup from "yup";

export default function SignIn() {
    return (
        <div alignContent="center">
            <Container
                style={{
                    width: "100%",
                }}
            >
                <h1
                    style={{
                        color: "#fff",
                        textShadow: "#0652dd 1px 1px .5rem",
                        fontSize: "4rem",
                        textAlign: "center",
                        marginTop: "8rem",
                        borderBottom: "solid 4px #0652DD",
                        paddingBottom: "1rem",
                    }}
                >
                    Giriş yap
                </h1>
                <Formik
                    initialValues={{
                        email: "",
                        password: "",
                    }}
                    validationSchema={Yup.object({
                        email: Yup.string()
                            .email("E-Posta formata uygun değil!")
                            .required("Bu alan boş bırakılamaz!"),
                        password: Yup.string()
                            .required("Bu alan boş bırakılamaz!")
                            .min(6, "Parola en az 6 karakterden oluşmalıdır")
                            .max(
                                25,
                                "Parola 25 karakterden fazla olmamalıdır!"
                            ),
                    })}
                >
                    {({ values, errors, touched, handleChange }) => (
                        <Container
                            className="sign-in-form"
                            style={{
                                width: "23.58rem",
                                marginTop: "5rem",
                                border: "solid 4px #0652dd",
                                borderRadius: "8px",
                                height: "24rem",
                                paddingTop: "3rem",
                                backgroundColor: "#fff",
                                boxShadow:
                                    "8px 8px 10px 2px rgba(9, 132, 227, 0.4)",
                            }}
                        >
                            <Form>
                                <input
                                    id="email"
                                    type="email"
                                    placeholder="E-Posta"
                                    value={values.email}
                                    onChange={handleChange}
                                />
                                <input
                                    id="password"
                                    type="password"
                                    placeholder="Parola"
                                    value={values.password}
                                    onChange={handleChange}
                                />
                                <Button type="submit" size="tiny">
                                    Giriş Yap
                                </Button>
                            </Form>
                            <Link to="/signup">
                                <p
                                    style={{
                                        marginLeft: "51%",
                                        textDecoration: "underline",
                                        marginTop: "1.7rem",
                                        fontSize: "1.1rem",
                                    }}
                                >
                                    Hesabın yoksa kayıt ol!
                                </p>
                            </Link>
                        </Container>
                    )}
                </Formik>
            </Container>
        </div>
    );
}
