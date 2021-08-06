import React, { useState, useEffect } from "react";
import {
    Card,
    CardGroup,
    Image,
    Container,
    Button,
    Table,
} from "semantic-ui-react";
import { useParams } from "react-router-dom";
import JobAdvertService from "../services/jobAdvertService";

function JobAdvertDetail() {
    const { id } = useParams();

    const [jobAdvert, setJobAdvert] = useState({});

    useEffect(() => {
        let jobAdvertService = new JobAdvertService();
        jobAdvertService
            .getJobAdvertById(id)
            .then((success) => setJobAdvert(success.data.data));
    }, []);

    console.log(jobAdvert);

    return (
        <div
            style={{
                minHeight: "50rem",
                boxShadow: "10px 10px 10px #casdas",
            }}
        >
            <Container>
                <CardGroup>
                    <Card
                        fluid
                        centered
                        style={{
                            minHeight: "Auto",
                            width: "50rem",
                            boxShadow: "0 4px 8px 0 rgba(0, 0, 0, 0.2)",
                        }}
                    >
                        <Card.Content>
                            <Image
                                floated="right"
                                size="tiny"
                                src={`${jobAdvert.employer?.pictureUrl}`}
                            />
                            <Card.Header>
                                {jobAdvert.jobPosition?.jobTitle}
                            </Card.Header>
                            <Card.Meta>{jobAdvert.city?.cityName}</Card.Meta>
                            <Card.Meta>
                                {jobAdvert.employer?.companyName}
                            </Card.Meta>
                            <Card.Description
                                style={{
                                    margin: "2rem",
                                    marginTop: "5rem",
                                    marginBottom: "5rem",
                                    lineHeight: "1.5rem",
                                    fontSize: "1.3rem",
                                    fontFamily:
                                        "New Century Schoolbook, TeX Gyre Schola, serif",
                                }}
                            >
                                {jobAdvert.description}
                            </Card.Description>
                            <Table celled>
                                <Table.Body>
                                    <Table.Row>
                                        <Table.Cell>
                                            <b>Aylık Kazanç</b>
                                        </Table.Cell>
                                        <Table.Cell>
                                            {jobAdvert.salary}₺
                                        </Table.Cell>
                                    </Table.Row>
                                    <Table.Row>
                                        <Table.Cell>
                                            <b>Açık Pozisyon Adedi</b>
                                        </Table.Cell>
                                        <Table.Cell>
                                            {jobAdvert.positionCount} Personel
                                        </Table.Cell>
                                    </Table.Row>
                                    <Table.Row>
                                        <Table.Cell>
                                            <b>Pozisyon Ünvanı</b>
                                        </Table.Cell>
                                        <Table.Cell>
                                            {jobAdvert.jobPosition?.jobTitle}
                                        </Table.Cell>
                                    </Table.Row>
                                    <Table.Row>
                                        <Table.Cell>
                                            <b>Yarı/Tam Zaman Şekli</b>
                                        </Table.Cell>
                                        <Table.Cell>
                                            {jobAdvert.partOrFullTime}
                                        </Table.Cell>
                                    </Table.Row>
                                    <Table.Row>
                                        <Table.Cell>
                                            <b>Uzaktan/Ofisten Çalışma Şekli</b>
                                        </Table.Cell>
                                        <Table.Cell>
                                            {jobAdvert.remoteOrStandartTyped}
                                        </Table.Cell>
                                    </Table.Row>
                                    <Table.Row>
                                        <Table.Cell>
                                            <b>İlan Başlangıç Tarihi</b>
                                        </Table.Cell>
                                        <Table.Cell>
                                            {jobAdvert.releaseDate}
                                        </Table.Cell>
                                    </Table.Row>
                                    <Table.Row>
                                        <Table.Cell>
                                            <b>İlan Kapanış Tarihi</b>
                                        </Table.Cell>
                                        <Table.Cell>
                                            {jobAdvert.expireDate}
                                        </Table.Cell>
                                    </Table.Row>
                                </Table.Body>
                                <Table.Footer>
                                    <Table.Row></Table.Row>
                                </Table.Footer>
                            </Table>
                            <Button fluid color="green">
                                Başvur
                            </Button>
                            <Button
                                fluid
                                color="blue"
                                style={{ marginTop: "1%" }}
                            >
                                İlanı Kaydet
                            </Button>
                        </Card.Content>
                    </Card>
                </CardGroup>
            </Container>
        </div>
    );
}

export default JobAdvertDetail;
