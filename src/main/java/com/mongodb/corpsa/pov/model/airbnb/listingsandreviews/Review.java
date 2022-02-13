
package com.mongodb.corpsa.pov.model.airbnb.listingsandreviews;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Document
@Generated("jsonschema2pojo")
public class Review {

    @JsonProperty("_id")
    private String id;
    @JsonProperty("date")
    private Instant date;
    @Field("listing_id")
    @JsonProperty("listingId")
    private String listing_id;
    @Field("reviewer_id")
    @JsonProperty("reviewerId")
    private String reviewer_id;
    @Field("reviewer_name")
    @JsonProperty("reviewerName")
    private String reviewer_name;
    @JsonProperty("comments")
    private String comments;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

}
