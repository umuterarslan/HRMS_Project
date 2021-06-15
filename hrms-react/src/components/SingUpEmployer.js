import React from "react";
import { Button, Container } from "semantic-ui-react";
import { Formik, Form, Field } from "formik";
import * as Yup from "yup";
import EmployerService from "../services/employerService";

export default function SingUpEmployer() {
    const employerService = new EmployerService();

    return (
        <div>
            <Container>
                <Formik
                    initialValues={{
                        id: 0,
                        companyName: "",
                        confirmPassword: "",
                        email: "",
                        password: "",
                        phoneNumber: "",
                        website: "",
                        termsAccepted: false,
                    }}
                    validationSchema={Yup.object({
                        companyName: Yup.string().required(
                            "Bu alan boş bırakılamaz!"
                        ),
                        website: Yup.string().required(
                            "Bu alan boş bırakılamaz!"
                        ),
                        phoneNumber: Yup.string().required(
                            "Bu alan boş bırakılamaz"
                        ),
                        email: Yup.string()
                            .email("E-Posta formatı doğru değil")
                            .required("Bu alan boş bırakılamaz!"),
                        password: Yup.string()
                            .required("Bu alan boş bırakılamaz!")
                            .min(6, "Parola en az 6 karakterden oluşmalıdır")
                            .max(
                                25,
                                "Parola 25 karakterden fazla olmamalıdır!"
                            ),
                        confirmPassword: Yup.string().required(
                            "Bu alan boş bırakılamaz! Lütfen parolanı doğrula!"
                        ),
                        termsAccepted: Yup.boolean().required(
                            "Kayıt olabilmek için sözleşme kabul edilmelidir!"
                        ),
                    })}
                    onSubmit={(values) => {
                        if (!values.termsAccepted) {
                            console.log("Sözleşme kabul edilmeli!");
                        } else if (values.password !== values.confirmPassword) {
                            console.log("Parola doğrulaması hatalı!");
                        } else {
                            const regulated = {
                                companyName: values.companyName,
                                email: values.email,
                                website: values.website,
                                id: values.id,
                                phoneNumber: values.phoneNumber,
                                password: values.password,
                            };
                            employerService
                                .addEmployer(regulated)
                                .then((res) => {
                                    console.log(res);
                                    alert(res);
                                })
                                .catch((err) => {
                                    console.log(err);
                                });
                        }
                    }}
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
                            className="sign-up-form"
                            style={{
                                width: "30rem",
                            }}
                        >
                            <input
                                id="companyName"
                                type="text"
                                placeholder="Şirket Adı"
                                value={values.companyName}
                                onChange={handleChange}
                            />
                            {errors.companyName && touched.companyName ? (
                                <div>{errors.companyName}</div>
                            ) : null}
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
                                id="website"
                                type="text"
                                placeholder="Şirket Web Adresi"
                                value={values.website}
                                onChange={handleChange}
                            />
                            {errors.website && touched.website ? (
                                <div>{errors.website}</div>
                            ) : null}
                            <input
                                id="phoneNumber"
                                type="text"
                                placeholder="Telefon Numarası"
                                value={values.phoneNumber}
                                onChange={handleChange}
                            />
                            {errors.phoneNumber && touched.phoneNumber ? (
                                <div>{errors.firstName}</div>
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
                            <input
                                id="confirmPassword"
                                type="password"
                                placeholder="Parola Tekrar"
                                value={values.confirmPassword}
                                onChange={handleChange}
                            />
                            {errors.confirmPassword &&
                            touched.confirmPassword ? (
                                <div>{errors.confirmPassword}</div>
                            ) : null}
                            <label className="checkbox-div">
                                <input
                                    id="termsAccepted"
                                    type="checkbox"
                                    onChange={handleChange}
                                    onClick={() =>
                                        (values.termsAccepted = true)
                                    }
                                />
                                {errors.termsAccepted &&
                                touched.termsAccepted ? (
                                    <div>{errors.termsAccepted}</div>
                                ) : null}
                                Kullunıcı sözleşmesini okudum kabul ediyorum.
                            </label>
                            <Button floated="right" type="submit">
                                Üye Ol
                            </Button>
                        </Form>
                    )}
                </Formik>
            </Container>
        </div>
    );
}
