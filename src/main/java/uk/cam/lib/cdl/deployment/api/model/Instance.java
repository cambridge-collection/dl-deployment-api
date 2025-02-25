package uk.cam.lib.cdl.deployment.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * Instance
 */
@Validated
public class Instance implements Comparable<Instance> {
    @JsonProperty("instanceId")
    private String instanceId = null;

    @JsonProperty("version")
    private String version = null;

    @JsonProperty("url")
    private String url = null;

    @JsonProperty("displayOrder")
    private int displayOrder = 0;

    public Instance instanceId(String instanceId) {
        this.instanceId = instanceId;
        return this;
    }

    /**
     * Get displayOrder
     *
     * @return displayOrder
     **/
    @NotNull

    public int getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }

    public Instance displayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
        return this;
    }


    /**
     * Get instanceId
     *
     * @return instanceId
     **/
    @NotNull

    public String getInstanceId() {
        return instanceId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    public Instance version(String version) {
        this.version = version;
        return this;
    }

    /**
     * Get version
     *
     * @return version
     **/
    @NotNull

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * Get version
     *
     * @return version
     **/
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Instance instance = (Instance) o;
        return Objects.equals(this.instanceId, instance.instanceId) &&
            Objects.equals(this.version, instance.version) &&
            Objects.equals(this.url, instance.url) &&
            Objects.equals(this.displayOrder, instance.displayOrder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(displayOrder, instanceId, version, url);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Instance {\n");

        sb.append("    displayOrder: ").append(toIndentedString(displayOrder)).append("\n");
        sb.append("    instanceId: ").append(toIndentedString(Integer.valueOf(instanceId))).append("\n");
        sb.append("    version: ").append(toIndentedString(version)).append("\n");
        sb.append("    url: ").append(toIndentedString(url)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

    @Override
    public int compareTo(Instance instance) {
        return this.getDisplayOrder() - instance.getDisplayOrder();
    }
}
