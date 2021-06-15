import React from "react";
import { Button, Container } from "semantic-ui-react";
import { Formik, Form } from "formik";
import * as Yup from "yup";
import JobSeekerService from "../services/jobSeekerService";

export default function SignUpJobSeeker() {
    const jobSeekerService = new JobSeekerService();

    return (
        <div>
            <Container>
                <Formik
                    initialValues={{
                        id: 0,
                        firstName: "",
                        lastName: "",
                        identityNumber: "",
                        email: "",
                        password: "",
                        confirmPassword: "",
                        termsAccepted: false,
                    }}
                    validationSchema={Yup.object({
                        firstName: Yup.string().required(
                            "Bu alan boş bırakılamaz!"
                        ),
                        lastName: Yup.string().required(
                            "Bu alan boş bırakılamaz!"
                        ),
                        identityNumber: Yup.string()
                            .required("Bu alan boş bırakılamaz")
                            .min(
                                11,
                                "Vatandaşlık numarası 11 karakter içermelidir!"
                            )
                            .max(
                                11,
                                "Vatandaşlık numarası 11 karakter içermelidir!"
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
                                birthDate: values.birthDate,
                                email: values.email,
                                firstName: values.firstName,
                                id: values.id,
                                identityNumber: values.identityNumber,
                                lastName: values.lastName,
                                password: values.password,
                            };
                            jobSeekerService
                                .addJobSeeker(regulated)
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
                            onSubmit={handleSubmit}
                            className="sign-up-form"
                            style={{
                                width: "30rem",
                            }}
                        >
                            <input
                                id="firstName"
                                type="text"
                                placeholder="Elijah"
                                value={values.firstName}
                                onChange={handleChange}
                            />
                            {errors.firstName && touched.firstName ? (
                                <div>{errors.firstName}</div>
                            ) : null}
                            <input
                                id="lastName"
                                type="text"
                                placeholder="Soyad"
                                value={values.lastName}
                                onChange={handleChange}
                            />
                            {errors.lastName && touched.lastName ? (
                                <div>{errors.lastName}</div>
                            ) : null}
                            <input
                                id="identityNumber"
                                type="text"
                                placeholder="Vatandaşlık Numarası"
                                value={values.identityNumber}
                                onChange={handleChange}
                            />
                            {errors.identityNumber && touched.identityNumber ? (
                                <div>{errors.identityNumber}</div>
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
                                id="birthDate"
                                type="date"
                                placeholder="Doğum Tarihi"
                                value={values.birthDate}
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
                            <input
                                id="passwordConfirm"
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
