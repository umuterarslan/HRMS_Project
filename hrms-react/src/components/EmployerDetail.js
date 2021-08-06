import React, { useState, useEffect } from "react";
import { Card, Icon, Image, Button, Grid, Label } from "semantic-ui-react";
import { Link } from "react-router-dom";
import EmployerService from "../services/employerService";
import JobAdvertService from "../services/jobAdvertService";
import { toast, ToastContainer } from "react-toastify";

export default function EmployerDetail() {
    const employerId = 3;

    const employerService = new EmployerService();
    const jobAdvertService = new JobAdvertService();

    const [employer, setEmployer] = useState({});
    const [numberOfJobAdverts, setNumberOfJobAdverts] = useState(0);
    const [jobAdverts, setJobAdverts] = useState([]);

    useEffect(() => {
        employerService.getEmployerById(employerId).then((success) => {
            setEmployer(success.data.data);
        });
        jobAdvertService
            .getNumberOfJobAdvertsByEmployerId(employerId)
            .then((success) => {
                setNumberOfJobAdverts(success.data.data);
            });
        jobAdvertService
            .getActiveAndConfirmedByEmployerId(employerId)
            .then((success) => {
                setJobAdverts(success.data.data);
            });
    }, []);

    console.log(jobAdverts);

    return (
        <div>
            <ToastContainer />
            <Grid>
                <Grid.Row>
                    <Grid.Column width={5}>
                        <div style={{ position: "fixed" }}>
                            <h3>
                                <Label
                                    color="blue"
                                    size="large"
                                    pointing="below"
                                >
                                    Şirket detayları
                                </Label>
                            </h3>
                            <Card>
                                <Image
                                    src={`${employer.pictureUrl}`}
                                    centered
                                    style={{
                                        height: "14rem",
                                        width: "20.7rem",
                                    }}
                                />
                                <Card.Content>
                                    <Card.Header>
                                        {" "}
                                        {employer.companyName}
                                    </Card.Header>
                                    <Card.Meta>
                                        {employer.phoneNumber}
                                    </Card.Meta>
                                    <Card.Description>
                                        <Icon name="mail" />
                                        {employer.email}
                                    </Card.Description>
                                    <Card.Description>
                                        <Icon name="cloud" />
                                        {employer.website}
                                    </Card.Description>
                                </Card.Content>
                                <Card.Content extra>
                                    <Icon name="building" color="blue" />
                                    <span style={{ color: "black" }}>
                                        Şirkete ait {numberOfJobAdverts} adet iş
                                        ilanı vardır.
                                    </span>
                                </Card.Content>
                            </Card>
                            {employer.reqFlag ? (
                                <Label
                                    color="red"
                                    size="large"
                                    style={{ width: "97.5%" }}
                                >
                                    <Icon
                                        name="warning"
                                        color="white"
                                        size="large"
                                    />
                                    Güncelleme için onay bekleniyor.
                                </Label>
                            ) : null}
                        </div>
                    </Grid.Column>
                    <Grid.Column width={2}>
                        <div
                            style={{
                                borderLeft: "solid 1px #b2bec3",
                                height: "70%",
                                position: "fixed",
                            }}
                        ></div>
                    </Grid.Column>
                    <Grid.Column width={9}>
                        <h3>
                            <Label color="green" size="large" pointing="below">
                                Şirkete ait iş ilanları
                            </Label>
                        </h3>
                        <div className="job-adverts-for-detail">
                            <Grid>
                                <Grid.Row>
                                    <Card.Group>
                                        {jobAdverts.map((jobAdvert) => (
                                            <Grid.Column
                                                width={4}
                                                style={{
                                                    marginLeft: "2%",
                                                    marginBottom: "2%",
                                                }}
                                            >
                                                <Card key={jobAdvert.id}>
                                                    <Card.Content>
                                                        <Card.Header>
                                                            {
                                                                jobAdvert
                                                                    .jobPosition
                                                                    ?.jobTitle
                                                            }
                                                        </Card.Header>
                                                        <Card.Meta>
                                                            {
                                                                jobAdvert.city
                                                                    .cityName
                                                            }
                                                        </Card.Meta>
                                                        <Card.Description>
                                                            {
                                                                jobAdvert.expireDate
                                                            }
                                                        </Card.Description>
                                                    </Card.Content>
                                                    <Card.Content extra>
                                                        <Button
                                                            basic
                                                            color="green"
                                                            fluid
                                                            as={Link}
                                                            to={`/jobAdvertDetail/${jobAdvert.id}`}
                                                        >
                                                            Detaylar
                                                        </Button>
                                                    </Card.Content>
                                                </Card>
                                            </Grid.Column>
                                        ))}
                                    </Card.Group>
                                </Grid.Row>
                            </Grid>
                        </div>
                    </Grid.Column>
                </Grid.Row>
            </Grid>
        </div>
    );
}
