import React from "react";
import { Button, Container } from "semantic-ui-react";
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
                        textShadow: "#0984e3 1px 1px 0.8rem",
                        fontSize: "4rem",
                        textAlign: "center",
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
                    {({
                        values,
                        errors,
                        touched,
                        handleSubmit,
                        handleChange,
                        isSubmitting,
                        dirty,
                    }) => (
                        <Form
                            className="sign-up-in-form"
                            style={{
                                width: "23.3rem",
                                margin: "7rem auto",
                                border: "solid 2px #b2bec3",
                                height: "19rem",
                                paddingTop: "3rem",
                                backgroundColor: "#dfe6e9",
                                boxShadow: "2px 2px 2px 2px rgba(0, 0, 0, 0.1)",
                            }}
                        >
                            <input
                                id="email"
                                type="email"
                                placeholder="E-Posta"
                                value={values.email}
                                onChange={handleChange}
                            />
                            {errors.email && touched.email ? (
                                <div>{errors.email}</div>
                            ) : null}
                            <input
                                id="password"
                                type="password"
                                placeholder="Parola"
                                value={values.password}
                                onChange={handleChange}
                            />
                            {errors.password && touched.password ? (
                                <div>{errors.password}</div>
                            ) : null}
                            <Button floated="right" type="submit">
                                Giriş Yap
                            </Button>
                        </Form>
                    )}
                </Formik>
            </Container>
        </div>
    );
}
