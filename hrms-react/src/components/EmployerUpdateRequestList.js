import React, { useState, useEffect } from "react";
import { toast, ToastContainer } from "react-toastify";
import { Card, Icon, Image, Label, Grid, Button } from "semantic-ui-react";
import EmployerUpdateRequestService from "../services/employerUpdateRequestService";
import EmployerService from "../services/employerService";

export default function EmployerUpdateRequestList() {
    const employerUpdateRequestService = new EmployerUpdateRequestService();
    const employerService = new EmployerService();

    const [employerUpdateRequestList, setEmployerUpdateRequestList] = useState(
        []
    );

    const getUpdateRequests = () => {
        employerUpdateRequestService
            .getAllEmployerUpdateRequest()
            .then((success) => {
                setEmployerUpdateRequestList(success.data.data);
            });
    };

    useEffect(() => {
        getUpdateRequests();
    }, []);

    const acceptRequest = (
        companyName,
        email,
        employerId,
        phoneNumber,
        website,
        requestId
    ) => {
        employerService
            .updateEmployer(
                employerId,
                companyName,
                email,
                phoneNumber,
                website
            )
            .then((success) => {
                console.log(success);
                toast.success("Güncelleme isteği onaylandı.");
                employerUpdateRequestService
                    .deleteEmployerUpdateRequest(requestId)
                    .then(() => {
                        employerService.setUpdateRequest(employerId, false);
                        getUpdateRequests();
                    });
            })
            .catch(() => {
                toast.error("Bir hata oluştu!");
            });
    };

    const deleteRequest = (employerId, requestId) => {
        employerUpdateRequestService
            .deleteEmployerUpdateRequest(requestId)
            .then((success) => {
                employerService.setUpdateRequest(employerId, false);
                getUpdateRequests();
                toast.success(success.data.message);
            })
            .catch(() => {
                toast.error("Bir hata oluştu!");
            });
    };

    return (
        <>
            <ToastContainer />
            <div
                style={{
                    textAlign: "center",
                }}
            >
                <h1
                    style={{
                        marginBottom: "5%",
                        borderBottom: "1px solid #555",
                    }}
                >
                    Şirketlere ait güncelleme istekleri.
                </h1>
                <Grid>
                    <Grid.Row>
                        {employerUpdateRequestList.map((updateRequest) => (
                            <Grid.Column
                                width={5}
                                style={{ marginBottom: "2%" }}
                            >
                                <Card key={updateRequest.id}>
                                    <Card.Content>
                                        <Image
                                            size="mini"
                                            src={`${updateRequest.employer.pictureUrl}`}
                                        />
                                    </Card.Content>
                                    <Card.Content>
                                        <Label color="grey" image size="small">
                                            {updateRequest.employer.companyName}
                                            <Label.Detail>
                                                <Icon name="angle double right" />
                                                {updateRequest.companyName}
                                            </Label.Detail>
                                        </Label>
                                    </Card.Content>
                                    <Card.Content>
                                        <Label color="grey" image size="small">
                                            {updateRequest.employer.email}
                                            <Label.Detail>
                                                <Icon name="angle double right" />
                                                {updateRequest.email}
                                            </Label.Detail>
                                        </Label>
                                    </Card.Content>
                                    <Card.Content>
                                        <Label color="grey" image size="small">
                                            {updateRequest.employer.website}
                                            <Label.Detail>
                                                <Icon name="angle double right" />
                                                {updateRequest.website}
                                            </Label.Detail>
                                        </Label>
                                    </Card.Content>
                                    <Card.Content>
                                        <Label color="grey" image size="small">
                                            {updateRequest.employer.phoneNumber}
                                            <Label.Detail>
                                                <Icon name="angle double right" />
                                                {updateRequest.phoneNumber}
                                            </Label.Detail>
                                        </Label>
                                    </Card.Content>
                                    <Card.Content>
                                        <Button
                                            color="red"
                                            onClick={() => {
                                                deleteRequest(
                                                    updateRequest.employer.id,
                                                    updateRequest.id
                                                );
                                            }}
                                        >
                                            İptal Et
                                        </Button>
                                        <Button
                                            color="green"
                                            onClick={() => {
                                                acceptRequest(
                                                    updateRequest.companyName,
                                                    updateRequest.email,
                                                    updateRequest.employer.id,
                                                    updateRequest.phoneNumber,
                                                    updateRequest.website,
                                                    updateRequest.id
                                                );
                                            }}
                                        >
                                            Onayla
                                        </Button>
                                    </Card.Content>
                                </Card>
                            </Grid.Column>
                        ))}
                    </Grid.Row>
                </Grid>
            </div>
        </>
    );
}
