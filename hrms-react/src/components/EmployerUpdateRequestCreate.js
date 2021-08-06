import React, { useState, useEffect } from "react";
import { Formik, Form, Field } from "formik";
import * as Yup from "yup";
import { FormField, Button, Label } from "semantic-ui-react";
import { ToastContainer, toast } from "react-toastify";
import EmployerService from "../services/employerService";
import EmployerUpdateRequestService from "../services/employerUpdateRequestService";

export default function EmployerUpdateRequestCreate() {
    const employerId = 3;

    const employerService = new EmployerService();
    const employerUpdateRequestService = new EmployerUpdateRequestService();

    const [employer, setEmployer] = useState({});

    useEffect(() => {
        employerService.getEmployerById(employerId).then((success) => {
            setEmployer(success.data.data);
        });
    }, []);

    const initialValues = {
        companyName: employer.companyName,
        email: employer.email,
        employerId: employer.id,
        phoneNumber: employer.phoneNumber,
        website: employer.website,
    };

    const formSchema = Yup.object({
        companyName: Yup.string(),
        email: Yup.string().email("E-Posta formatına uygun olmalıdır!"),
        phoneNumber: Yup.number().typeError("Sadece rakamlardan oluşmalıdır!"),
        website: Yup.string(),
    });

    return (
        <div
            style={{
                width: "35%",
                marginLeft: "30%",
                marginTop: "12%",
            }}
        >
            <ToastContainer />
            <h2>
                {employer.companyName} şirketi için güncelleme isteği oluştur.
            </h2>
            <div
                style={{
                    border: "solid 4px #0652dd",
                    boxShadow: "8px 8px 10px 2px rgba(9, 132, 227, 0.4)",
                    borderRadius: "5px",
                    padding: "10px",
                }}
            >
                <Formik
                    enableReinitialize={true}
                    initialValues={initialValues}
                    validationSchema={formSchema}
                    onSubmit={(values, actions) => {
                        employerUpdateRequestService
                            .addEmployerUpdateRequest(values)
                            .then((success) => {
                                toast.success(success.data.message);
                                setTimeout(() => {
                                    actions.resetForm();
                                    actions.setSubmitting(false);
                                }, 1000);
                            });
                        employerService.setUpdateRequest(employerId, true);
                    }}
                >
                    {({ values, errors, touched, dirty, isSubmitting }) => (
                        <Form className="ui form">
                            <FormField>
                                Şirket Adı
                                <Field
                                    as="input"
                                    name="companyName"
                                    type="text"
                                    value={values.companyName}
                                    defaultValue={initialValues.companyName}
                                />
                                {errors.companyName && touched.companyName ? (
                                    <Label basic color="red" pointing>
                                        {errors.companyName}
                                    </Label>
                                ) : null}
                            </FormField>
                            <FormField>
                                E-Posta
                                <Field
                                    as="input"
                                    name="email"
                                    type="email"
                                    value={values.email}
                                    defaultValue={initialValues.email}
                                />
                                {errors.email && touched.email ? (
                                    <Label basic color="red" pointing>
                                        {errors.email}
                                    </Label>
                                ) : null}
                            </FormField>
                            <FormField>
                                Web Adresi
                                <Field
                                    as="input"
                                    name="website"
                                    type="text"
                                    value={values.website}
                                    defaultValue={initialValues.website}
                                />
                                {errors.website && touched.website ? (
                                    <Label basic color="red" pointing>
                                        {errors.website}
                                    </Label>
                                ) : null}
                            </FormField>
                            <FormField>
                                Telefon Numarası
                                <Field
                                    as="input"
                                    name="phoneNumber"
                                    type="text"
                                    value={values.phoneNumber}
                                    defaultValue={initialValues.phoneNumber}
                                />
                                {errors.phoneNumber && touched.phoneNumber ? (
                                    <Label basic color="red" pointing>
                                        {errors.phoneNumber}
                                    </Label>
                                ) : null}
                            </FormField>
                            <Button
                                type="submit"
                                color="green"
                                disabled={!dirty || isSubmitting}
                                fluid
                            >
                                Güncelleme isteği gönder
                            </Button>
                        </Form>
                    )}
                </Formik>
            </div>
        </div>
    );
}
