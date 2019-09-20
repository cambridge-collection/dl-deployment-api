package uk.cam.lib.cdl.deployment.api.model;

import java.net.URL;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.*;

/**
 * Instance
 */
@Validated
public class Instance   {
  @JsonProperty("instanceId")
  private String instanceId = null;

  @JsonProperty("version")
  private String version = null;

  @JsonProperty("url")
  private String url = null;

  public Instance instanceId(String instanceId) {
    this.instanceId = instanceId;
    return this;
  }

  /**
   * Get instanceId
   * @return instanceId
  **/
  @ApiModelProperty(example = "dev", required = true, value = "")
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
   * @return version
  **/
  @ApiModelProperty(example = "dl-version-123", required = true, value = "")
  @NotNull

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }

    /**
     * Get version
     * @return version
     **/
    @ApiModelProperty(example = "https://www.my.digital.library.ac.uk", required = true, value = "")

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url=url;
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
        Objects.equals(this.url, instance.url);
  }

  @Override
  public int hashCode() {
    return Objects.hash(instanceId, version, url);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Instance {\n");

    sb.append("    instanceId: ").append(toIndentedString(instanceId)).append("\n");
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
}
