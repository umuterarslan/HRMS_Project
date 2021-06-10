import React, { useState, useEffect } from "react";
import { Card, CardGroup, Image } from "semantic-ui-react";
import JobAdvertService from "../services/jobAdvertService";

export default function JobAdvertList() {
    const [jobAdverts, setJobAderts] = useState([]);

    useEffect(() => {
        let jobAdvertService = new JobAdvertService();
        jobAdvertService
            .getJobAdverts()
            .then((success) => setJobAderts(success.data.data));
    });

    return (
        <div>
            <CardGroup>
                {jobAdverts.map((jobAdvert) => (
                    <Card
                        style={{
                            width: "100%",
                        }}
                    >
                        <Card.Content>
                            <Image
                                floated="right"
                                size="tiny"
                                src="https://react.semantic-ui.com/images/avatar/large/steve.jpg"
                            />
                            <Card.Header>
                                {jobAdvert.jobPosition.jobTitle}
                            </Card.Header>
                            <Card.Meta>{jobAdvert.city.cityName}</Card.Meta>
                            <Card.Meta>
                                {jobAdvert.employer.companyName}
                            </Card.Meta>
                            <Card.Description>
                                {jobAdvert.expireDate}
                            </Card.Description>
                        </Card.Content>
                    </Card>
                ))}
            </CardGroup>
        </div>
    );
}
