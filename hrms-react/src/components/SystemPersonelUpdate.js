import React, { useState, useEffect } from "react";
import { Formik, Form, Field } from "formik";
import * as Yup from "yup";
import { FormField, Button, Label } from "semantic-ui-react";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import SystemPersonelService from "../services/systemPersonelService";

export default function SystemPersonelUpdate() {
    const systemPersonelId = 10;

    const systemPersonelService = new SystemPersonelService();

    const [systemPersonel, setSystemPersonel] = useState({});

    const getSystemPersonel = () => {
        systemPersonelService
            .getSystemPersonelById(systemPersonelId)
            .then((success) => {
                setSystemPersonel(success.data.data);
            });
    };

    useEffect(() => {
        getSystemPersonel();
    }, []);

    const initialValues = {
        id: systemPersonelId,
        username: "",
        email: "",
    };

    const formSchema = Yup.object({
        email: Yup.string()
            .email("E-Posta formatına uygun olmalıdır!")
            .required("Bu alan boş bırakılamaz!"),
        username: Yup.string().required("Bu alan boş bırakılamaz!"),
    });

    return (
        <div
            style={{
                width: "35%",
                marginLeft: "33%",
                marginTop: "12%",
            }}
        >
            <ToastContainer />
            <h2>Sistem personeli hesabı güncelle.</h2>
            <div
                style={{
                    border: "solid 4px #0652dd",
                    boxShadow: "8px 8px 10px 2px rgba(9, 132, 227, 0.4)",
                    borderRadius: "5px",
                    padding: "10px",
                }}
            >
                <Formik
                    initialValues={initialValues}
                    validationSchema={formSchema}
                    onSubmit={(values, actions) => {
                        systemPersonelService
                            .updateSystemPersonel(
                                systemPersonelId,
                                values.email,
                                values.username
                            )
                            .then((success) => {
                                console.log(success.data.message);
                                if (
                                    success.data.message ===
                                    "Kullanılan E-Posta adresi zaten kayıtlı!"
                                ) {
                                    toast.error(success.data.message);
                                } else if (success.data.success === false) {
                                    toast.error("Bir hata oluştu!");
                                } else {
                                    toast.success(success.data.message);
                                    getSystemPersonel();
                                    setTimeout(() => {
                                        actions.setValues({
                                            id: 0,
                                            username: "",
                                            email: "",
                                        });
                                        actions.resetForm();
                                        actions.setSubmitting(false);
                                    }, 1000);
                                }
                            })
                            .catch(() => {
                                toast.error("Sunucu hatası!");
                            });
                    }}
                >
                    {({ values, errors, touched, dirty, isSubmitting }) => (
                        <Form className="ui form">
                            <FormField>
                                Kullanıcı Adı
                                <Field
                                    placeHolder={systemPersonel.username}
                                    name="username"
                                    type="text"
                                    value={values.username}
                                ></Field>
                                {errors.username && touched.username ? (
                                    <Label basic color="red" pointing>
                                        {errors.username}
                                    </Label>
                                ) : null}
                            </FormField>
                            <FormField>
                                E-Posta
                                <Field
                                    placeHolder={systemPersonel.email}
                                    name="email"
                                    type="email"
                                    value={values.email}
                                ></Field>
                                {errors.email && touched.email ? (
                                    <Label basic color="red" pointing>
                                        {errors.email}
                                    </Label>
                                ) : null}
                            </FormField>
                            <Button
                                type="submit"
                                color="green"
                                disabled={!dirty || isSubmitting}
                                fluid
                            >
                                Hesap Güncelle
                            </Button>
                        </Form>
                    )}
                </Formik>
            </div>
        </div>
    );
}
