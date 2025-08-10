package com.amazonaws.services.s3.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.services.s3.internal.DeleteObjectsResponse;
import com.amazonaws.services.s3.internal.ObjectExpirationResult;
import com.amazonaws.services.s3.internal.S3HttpUtils;
import com.amazonaws.services.s3.internal.S3RequesterChargedResult;
import com.amazonaws.services.s3.internal.S3VersionResult;
import com.amazonaws.services.s3.internal.ServerSideEncryptionResult;
import com.amazonaws.services.s3.internal.ServiceUtils;
import com.amazonaws.services.s3.model.AbortIncompleteMultipartUpload;
import com.amazonaws.services.s3.model.AccessControlList;
import com.amazonaws.services.s3.model.AmazonS3Exception;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.BucketAccelerateConfiguration;
import com.amazonaws.services.s3.model.BucketCrossOriginConfiguration;
import com.amazonaws.services.s3.model.BucketLifecycleConfiguration;
import com.amazonaws.services.s3.model.BucketLoggingConfiguration;
import com.amazonaws.services.s3.model.BucketReplicationConfiguration;
import com.amazonaws.services.s3.model.BucketTaggingConfiguration;
import com.amazonaws.services.s3.model.BucketVersioningConfiguration;
import com.amazonaws.services.s3.model.BucketWebsiteConfiguration;
import com.amazonaws.services.s3.model.CORSRule;
import com.amazonaws.services.s3.model.CanonicalGrantee;
import com.amazonaws.services.s3.model.CompleteMultipartUploadResult;
import com.amazonaws.services.s3.model.CopyObjectResult;
import com.amazonaws.services.s3.model.DeleteObjectsResult$DeletedObject;
import com.amazonaws.services.s3.model.EmailAddressGrantee;
import com.amazonaws.services.s3.model.Grantee;
import com.amazonaws.services.s3.model.GroupGrantee;
import com.amazonaws.services.s3.model.InitiateMultipartUploadResult;
import com.amazonaws.services.s3.model.ListBucketAnalyticsConfigurationsResult;
import com.amazonaws.services.s3.model.ListBucketInventoryConfigurationsResult;
import com.amazonaws.services.s3.model.ListBucketMetricsConfigurationsResult;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.MultiObjectDeleteException;
import com.amazonaws.services.s3.model.MultipartUpload;
import com.amazonaws.services.s3.model.MultipartUploadListing;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.Owner;
import com.amazonaws.services.s3.model.PartListing;
import com.amazonaws.services.s3.model.PartSummary;
import com.amazonaws.services.s3.model.Permission;
import com.amazonaws.services.s3.model.RedirectRule;
import com.amazonaws.services.s3.model.ReplicationDestinationConfig;
import com.amazonaws.services.s3.model.ReplicationRule;
import com.amazonaws.services.s3.model.RoutingRule;
import com.amazonaws.services.s3.model.RoutingRuleCondition;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.amazonaws.services.s3.model.S3VersionSummary;
import com.amazonaws.services.s3.model.Tag;
import com.amazonaws.services.s3.model.TagSet;
import com.amazonaws.services.s3.model.VersionListing;
import com.amazonaws.services.s3.model.analytics.AnalyticsAndOperator;
import com.amazonaws.services.s3.model.analytics.AnalyticsConfiguration;
import com.amazonaws.services.s3.model.analytics.AnalyticsExportDestination;
import com.amazonaws.services.s3.model.analytics.AnalyticsFilter;
import com.amazonaws.services.s3.model.analytics.AnalyticsFilterPredicate;
import com.amazonaws.services.s3.model.analytics.AnalyticsPrefixPredicate;
import com.amazonaws.services.s3.model.analytics.AnalyticsS3BucketDestination;
import com.amazonaws.services.s3.model.analytics.AnalyticsTagPredicate;
import com.amazonaws.services.s3.model.analytics.StorageClassAnalysis;
import com.amazonaws.services.s3.model.analytics.StorageClassAnalysisDataExport;
import com.amazonaws.services.s3.model.inventory.InventoryConfiguration;
import com.amazonaws.services.s3.model.inventory.InventoryDestination;
import com.amazonaws.services.s3.model.inventory.InventoryFilter;
import com.amazonaws.services.s3.model.inventory.InventoryPrefixPredicate;
import com.amazonaws.services.s3.model.inventory.InventoryS3BucketDestination;
import com.amazonaws.services.s3.model.inventory.InventorySchedule;
import com.amazonaws.services.s3.model.lifecycle.LifecycleAndOperator;
import com.amazonaws.services.s3.model.lifecycle.LifecycleFilter;
import com.amazonaws.services.s3.model.lifecycle.LifecycleFilterPredicate;
import com.amazonaws.services.s3.model.lifecycle.LifecyclePrefixPredicate;
import com.amazonaws.services.s3.model.lifecycle.LifecycleTagPredicate;
import com.amazonaws.services.s3.model.metrics.MetricsAndOperator;
import com.amazonaws.services.s3.model.metrics.MetricsConfiguration;
import com.amazonaws.services.s3.model.metrics.MetricsFilter;
import com.amazonaws.services.s3.model.metrics.MetricsFilterPredicate;
import com.amazonaws.services.s3.model.metrics.MetricsPrefixPredicate;
import com.amazonaws.services.s3.model.metrics.MetricsTagPredicate;
import com.amazonaws.util.DateUtils;
import com.amazonaws.util.StringUtils;
import com.google.android.vending.expansion.downloader.impl.DownloadsDB;
import com.google.common.net.HttpHeaders;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.webrtc.PeerConnectionFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

/* loaded from: classes.dex */
public class XmlResponsesSaxParser {
    public static final Log b = LogFactory.b(XmlResponsesSaxParser.class);
    public XMLReader a;

    public static class AccessControlListHandler extends AbstractHandler {
        public final AccessControlList c = new AccessControlList();
        public Grantee d = null;
        public Permission e = null;

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void i(String str, String str2, String str3) {
            if (l("AccessControlPolicy", "Owner")) {
                if (str2.equals("ID")) {
                    this.c.d().d(k());
                    return;
                } else {
                    if (str2.equals("DisplayName")) {
                        this.c.d().c(k());
                        return;
                    }
                    return;
                }
            }
            if (l("AccessControlPolicy", "AccessControlList")) {
                if (str2.equals("Grant")) {
                    this.c.f(this.d, this.e);
                    this.d = null;
                    this.e = null;
                    return;
                }
                return;
            }
            if (l("AccessControlPolicy", "AccessControlList", "Grant")) {
                if (str2.equals("Permission")) {
                    this.e = Permission.parsePermission(k());
                }
            } else if (l("AccessControlPolicy", "AccessControlList", "Grant", "Grantee")) {
                if (str2.equals("ID")) {
                    this.d.setIdentifier(k());
                    return;
                }
                if (str2.equals("EmailAddress")) {
                    this.d.setIdentifier(k());
                } else if (str2.equals(DownloadsDB.DownloadColumns.URI)) {
                    this.d = GroupGrantee.parseGroupGrantee(k());
                } else if (str2.equals("DisplayName")) {
                    ((CanonicalGrantee) this.d).a(k());
                }
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void j(String str, String str2, String str3, Attributes attributes) {
            if (l("AccessControlPolicy")) {
                if (str2.equals("Owner")) {
                    this.c.g(new Owner());
                }
            } else if (l("AccessControlPolicy", "AccessControlList", "Grant") && str2.equals("Grantee")) {
                String strI = XmlResponsesSaxParser.i("xsi:type", attributes);
                if ("AmazonCustomerByEmail".equals(strI)) {
                    this.d = new EmailAddressGrantee(null);
                } else if ("CanonicalUser".equals(strI)) {
                    this.d = new CanonicalGrantee(null);
                } else {
                    "Group".equals(strI);
                }
            }
        }
    }

    public static class BucketAccelerateConfigurationHandler extends AbstractHandler {
        public final BucketAccelerateConfiguration c = new BucketAccelerateConfiguration(null);

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void i(String str, String str2, String str3) {
            if (l("AccelerateConfiguration") && str2.equals("Status")) {
                this.c.a(k());
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void j(String str, String str2, String str3, Attributes attributes) {
        }
    }

    public static class BucketCrossOriginConfigurationHandler extends AbstractHandler {
        public CORSRule d;
        public final BucketCrossOriginConfiguration c = new BucketCrossOriginConfiguration(new ArrayList());
        public List<CORSRule.AllowedMethods> e = null;
        public List<String> f = null;
        public List<String> g = null;
        public List<String> h = null;

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void i(String str, String str2, String str3) {
            if (l("CORSConfiguration")) {
                if (str2.equals("CORSRule")) {
                    this.d.a(this.h);
                    this.d.b(this.e);
                    this.d.c(this.f);
                    this.d.d(this.g);
                    this.h = null;
                    this.e = null;
                    this.f = null;
                    this.g = null;
                    this.c.a().add(this.d);
                    this.d = null;
                    return;
                }
                return;
            }
            if (l("CORSConfiguration", "CORSRule")) {
                if (str2.equals("ID")) {
                    this.d.e(k());
                    return;
                }
                if (str2.equals("AllowedOrigin")) {
                    this.f.add(k());
                    return;
                }
                if (str2.equals("AllowedMethod")) {
                    this.e.add(CORSRule.AllowedMethods.fromValue(k()));
                    return;
                }
                if (str2.equals("MaxAgeSeconds")) {
                    this.d.f(Integer.parseInt(k()));
                } else if (str2.equals("ExposeHeader")) {
                    this.g.add(k());
                } else if (str2.equals("AllowedHeader")) {
                    this.h.add(k());
                }
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void j(String str, String str2, String str3, Attributes attributes) {
            if (l("CORSConfiguration")) {
                if (str2.equals("CORSRule")) {
                    this.d = new CORSRule();
                    return;
                }
                return;
            }
            if (l("CORSConfiguration", "CORSRule")) {
                if (str2.equals("AllowedOrigin")) {
                    if (this.f == null) {
                        this.f = new ArrayList();
                    }
                } else if (str2.equals("AllowedMethod")) {
                    if (this.e == null) {
                        this.e = new ArrayList();
                    }
                } else if (str2.equals("ExposeHeader")) {
                    if (this.g == null) {
                        this.g = new ArrayList();
                    }
                } else if (str2.equals("AllowedHeader") && this.h == null) {
                    this.h = new LinkedList();
                }
            }
        }
    }

    public static class BucketLifecycleConfigurationHandler extends AbstractHandler {
        public final BucketLifecycleConfiguration c = new BucketLifecycleConfiguration(new ArrayList());
        public BucketLifecycleConfiguration.Rule d;
        public BucketLifecycleConfiguration.Transition e;
        public BucketLifecycleConfiguration.NoncurrentVersionTransition f;
        public AbortIncompleteMultipartUpload g;
        public LifecycleFilter h;
        public List<LifecycleFilterPredicate> i;
        public String j;
        public String k;

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void i(String str, String str2, String str3) {
            if (l("LifecycleConfiguration")) {
                if (str2.equals("Rule")) {
                    this.c.a().add(this.d);
                    this.d = null;
                    return;
                }
                return;
            }
            if (l("LifecycleConfiguration", "Rule")) {
                if (str2.equals("ID")) {
                    this.d.h(k());
                    return;
                }
                if (str2.equals("Prefix")) {
                    this.d.j(k());
                    return;
                }
                if (str2.equals("Status")) {
                    this.d.k(k());
                    return;
                }
                if (str2.equals("Transition")) {
                    this.d.b(this.e);
                    this.e = null;
                    return;
                }
                if (str2.equals("NoncurrentVersionTransition")) {
                    this.d.a(this.f);
                    this.f = null;
                    return;
                } else if (str2.equals("AbortIncompleteMultipartUpload")) {
                    this.d.c(this.g);
                    this.g = null;
                    return;
                } else {
                    if (str2.equals("Filter")) {
                        this.d.g(this.h);
                        this.h = null;
                        return;
                    }
                    return;
                }
            }
            if (l("LifecycleConfiguration", "Rule", "Expiration")) {
                if (str2.equals("Date")) {
                    this.d.d(ServiceUtils.e(k()));
                    return;
                }
                if (str2.equals("Days")) {
                    this.d.e(Integer.parseInt(k()));
                    return;
                } else {
                    if (str2.equals("ExpiredObjectDeleteMarker") && "true".equals(k())) {
                        this.d.f(true);
                        return;
                    }
                    return;
                }
            }
            if (l("LifecycleConfiguration", "Rule", "Transition")) {
                if (str2.equals("StorageClass")) {
                    this.e.c(k());
                    return;
                } else if (str2.equals("Date")) {
                    this.e.a(ServiceUtils.e(k()));
                    return;
                } else {
                    if (str2.equals("Days")) {
                        this.e.b(Integer.parseInt(k()));
                        return;
                    }
                    return;
                }
            }
            if (l("LifecycleConfiguration", "Rule", "NoncurrentVersionExpiration")) {
                if (str2.equals("NoncurrentDays")) {
                    this.d.i(Integer.parseInt(k()));
                    return;
                }
                return;
            }
            if (l("LifecycleConfiguration", "Rule", "NoncurrentVersionTransition")) {
                if (str2.equals("StorageClass")) {
                    this.f.b(k());
                    return;
                } else {
                    if (str2.equals("NoncurrentDays")) {
                        this.f.a(Integer.parseInt(k()));
                        return;
                    }
                    return;
                }
            }
            if (l("LifecycleConfiguration", "Rule", "AbortIncompleteMultipartUpload")) {
                if (str2.equals("DaysAfterInitiation")) {
                    this.g.b(Integer.parseInt(k()));
                    return;
                }
                return;
            }
            if (l("LifecycleConfiguration", "Rule", "Filter")) {
                if (str2.equals("Prefix")) {
                    this.h.a(new LifecyclePrefixPredicate(k()));
                    return;
                }
                if (str2.equals("Tag")) {
                    this.h.a(new LifecycleTagPredicate(new Tag(this.j, this.k)));
                    this.j = null;
                    this.k = null;
                    return;
                } else {
                    if (str2.equals("And")) {
                        this.h.a(new LifecycleAndOperator(this.i));
                        this.i = null;
                        return;
                    }
                    return;
                }
            }
            if (l("LifecycleConfiguration", "Rule", "Filter", "Tag")) {
                if (str2.equals("Key")) {
                    this.j = k();
                    return;
                } else {
                    if (str2.equals("Value")) {
                        this.k = k();
                        return;
                    }
                    return;
                }
            }
            if (l("LifecycleConfiguration", "Rule", "Filter", "And")) {
                if (str2.equals("Prefix")) {
                    this.i.add(new LifecyclePrefixPredicate(k()));
                    return;
                } else {
                    if (str2.equals("Tag")) {
                        this.i.add(new LifecycleTagPredicate(new Tag(this.j, this.k)));
                        this.j = null;
                        this.k = null;
                        return;
                    }
                    return;
                }
            }
            if (l("LifecycleConfiguration", "Rule", "Filter", "And", "Tag")) {
                if (str2.equals("Key")) {
                    this.j = k();
                } else if (str2.equals("Value")) {
                    this.k = k();
                }
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void j(String str, String str2, String str3, Attributes attributes) {
            if (l("LifecycleConfiguration")) {
                if (str2.equals("Rule")) {
                    this.d = new BucketLifecycleConfiguration.Rule();
                    return;
                }
                return;
            }
            if (!l("LifecycleConfiguration", "Rule")) {
                if (l("LifecycleConfiguration", "Rule", "Filter") && str2.equals("And")) {
                    this.i = new ArrayList();
                    return;
                }
                return;
            }
            if (str2.equals("Transition")) {
                this.e = new BucketLifecycleConfiguration.Transition();
                return;
            }
            if (str2.equals("NoncurrentVersionTransition")) {
                this.f = new BucketLifecycleConfiguration.NoncurrentVersionTransition();
            } else if (str2.equals("AbortIncompleteMultipartUpload")) {
                this.g = new AbortIncompleteMultipartUpload();
            } else if (str2.equals("Filter")) {
                this.h = new LifecycleFilter();
            }
        }
    }

    public static class BucketLocationHandler extends AbstractHandler {
        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void i(String str, String str2, String str3) {
            if (h() && str2.equals("LocationConstraint")) {
                k().length();
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void j(String str, String str2, String str3, Attributes attributes) {
        }
    }

    public static class BucketLoggingConfigurationHandler extends AbstractHandler {
        public final BucketLoggingConfiguration c = new BucketLoggingConfiguration();

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void i(String str, String str2, String str3) {
            if (l("BucketLoggingStatus", "LoggingEnabled")) {
                if (str2.equals("TargetBucket")) {
                    this.c.d(k());
                } else if (str2.equals("TargetPrefix")) {
                    this.c.e(k());
                }
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void j(String str, String str2, String str3, Attributes attributes) {
        }
    }

    public static class BucketReplicationConfigurationHandler extends AbstractHandler {
        public final BucketReplicationConfiguration c = new BucketReplicationConfiguration();
        public String d;
        public ReplicationRule e;
        public ReplicationDestinationConfig f;

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void i(String str, String str2, String str3) {
            if (l("ReplicationConfiguration")) {
                if (!str2.equals("Rule")) {
                    if (str2.equals("Role")) {
                        this.c.b(k());
                        return;
                    }
                    return;
                } else {
                    this.c.a(this.d, this.e);
                    this.e = null;
                    this.d = null;
                    this.f = null;
                    return;
                }
            }
            if (!l("ReplicationConfiguration", "Rule")) {
                if (l("ReplicationConfiguration", "Rule", "Destination")) {
                    if (str2.equals("Bucket")) {
                        this.f.a(k());
                        return;
                    } else {
                        if (str2.equals("StorageClass")) {
                            this.f.b(k());
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            if (str2.equals("ID")) {
                this.d = k();
                return;
            }
            if (str2.equals("Prefix")) {
                this.e.b(k());
            } else if (str2.equals("Status")) {
                this.e.c(k());
            } else if (str2.equals("Destination")) {
                this.e.a(this.f);
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void j(String str, String str2, String str3, Attributes attributes) {
            if (l("ReplicationConfiguration")) {
                if (str2.equals("Rule")) {
                    this.e = new ReplicationRule();
                }
            } else if (l("ReplicationConfiguration", "Rule") && str2.equals("Destination")) {
                this.f = new ReplicationDestinationConfig();
            }
        }
    }

    public static class BucketTaggingConfigurationHandler extends AbstractHandler {
        public final BucketTaggingConfiguration c = new BucketTaggingConfiguration();
        public Map<String, String> d;
        public String e;
        public String f;

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void i(String str, String str2, String str3) {
            String str4;
            if (l("Tagging")) {
                if (str2.equals("TagSet")) {
                    this.c.a().add(new TagSet(this.d));
                    this.d = null;
                    return;
                }
                return;
            }
            if (l("Tagging", "TagSet")) {
                if (str2.equals("Tag")) {
                    String str5 = this.e;
                    if (str5 != null && (str4 = this.f) != null) {
                        this.d.put(str5, str4);
                    }
                    this.e = null;
                    this.f = null;
                    return;
                }
                return;
            }
            if (l("Tagging", "TagSet", "Tag")) {
                if (str2.equals("Key")) {
                    this.e = k();
                } else if (str2.equals("Value")) {
                    this.f = k();
                }
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void j(String str, String str2, String str3, Attributes attributes) {
            if (l("Tagging") && str2.equals("TagSet")) {
                this.d = new HashMap();
            }
        }
    }

    public static class BucketVersioningConfigurationHandler extends AbstractHandler {
        public final BucketVersioningConfiguration c = new BucketVersioningConfiguration();

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void i(String str, String str2, String str3) {
            if (l("VersioningConfiguration")) {
                if (str2.equals("Status")) {
                    this.c.b(k());
                    return;
                }
                if (str2.equals("MfaDelete")) {
                    String strK = k();
                    if (strK.equals("Disabled")) {
                        this.c.a(Boolean.FALSE);
                    } else if (strK.equals(PeerConnectionFactory.TRIAL_ENABLED)) {
                        this.c.a(Boolean.TRUE);
                    } else {
                        this.c.a(null);
                    }
                }
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void j(String str, String str2, String str3, Attributes attributes) {
        }
    }

    public static class BucketWebsiteConfigurationHandler extends AbstractHandler {
        public final BucketWebsiteConfiguration c = new BucketWebsiteConfiguration(null);
        public RoutingRuleCondition d = null;
        public RedirectRule e = null;
        public RoutingRule f = null;

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void i(String str, String str2, String str3) {
            if (l("WebsiteConfiguration")) {
                if (str2.equals("RedirectAllRequestsTo")) {
                    this.c.d(this.e);
                    this.e = null;
                    return;
                }
                return;
            }
            if (l("WebsiteConfiguration", "IndexDocument")) {
                if (str2.equals("Suffix")) {
                    this.c.c(k());
                    return;
                }
                return;
            }
            if (l("WebsiteConfiguration", "ErrorDocument")) {
                if (str2.equals("Key")) {
                    this.c.b(k());
                    return;
                }
                return;
            }
            if (l("WebsiteConfiguration", "RoutingRules")) {
                if (str2.equals("RoutingRule")) {
                    this.c.a().add(this.f);
                    this.f = null;
                    return;
                }
                return;
            }
            if (l("WebsiteConfiguration", "RoutingRules", "RoutingRule")) {
                if (str2.equals("Condition")) {
                    this.f.a(this.d);
                    this.d = null;
                    return;
                } else {
                    if (str2.equals("Redirect")) {
                        this.f.b(this.e);
                        this.e = null;
                        return;
                    }
                    return;
                }
            }
            if (l("WebsiteConfiguration", "RoutingRules", "RoutingRule", "Condition")) {
                if (str2.equals("KeyPrefixEquals")) {
                    this.d.b(k());
                    return;
                } else {
                    if (str2.equals("HttpErrorCodeReturnedEquals")) {
                        this.d.a(k());
                        return;
                    }
                    return;
                }
            }
            if (l("WebsiteConfiguration", "RedirectAllRequestsTo") || l("WebsiteConfiguration", "RoutingRules", "RoutingRule", "Redirect")) {
                if (str2.equals("Protocol")) {
                    this.e.c(k());
                    return;
                }
                if (str2.equals("HostName")) {
                    this.e.a(k());
                    return;
                }
                if (str2.equals("ReplaceKeyPrefixWith")) {
                    this.e.d(k());
                } else if (str2.equals("ReplaceKeyWith")) {
                    this.e.e(k());
                } else if (str2.equals("HttpRedirectCode")) {
                    this.e.b(k());
                }
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void j(String str, String str2, String str3, Attributes attributes) {
            if (l("WebsiteConfiguration")) {
                if (str2.equals("RedirectAllRequestsTo")) {
                    this.e = new RedirectRule();
                }
            } else if (l("WebsiteConfiguration", "RoutingRules")) {
                if (str2.equals("RoutingRule")) {
                    this.f = new RoutingRule();
                }
            } else if (l("WebsiteConfiguration", "RoutingRules", "RoutingRule")) {
                if (str2.equals("Condition")) {
                    this.d = new RoutingRuleCondition();
                } else if (str2.equals("Redirect")) {
                    this.e = new RedirectRule();
                }
            }
        }
    }

    public static class CompleteMultipartUploadHandler extends AbstractSSEHandler implements ObjectExpirationResult, S3VersionResult, S3RequesterChargedResult {
        public CompleteMultipartUploadResult c;
        public AmazonS3Exception d;
        public String e;
        public String f;
        public String g;

        @Override // com.amazonaws.services.s3.internal.S3VersionResult
        public void a(String str) {
            CompleteMultipartUploadResult completeMultipartUploadResult = this.c;
            if (completeMultipartUploadResult != null) {
                completeMultipartUploadResult.a(str);
            }
        }

        @Override // com.amazonaws.services.s3.internal.ObjectExpirationResult
        public void c(String str) {
            CompleteMultipartUploadResult completeMultipartUploadResult = this.c;
            if (completeMultipartUploadResult != null) {
                completeMultipartUploadResult.c(str);
            }
        }

        @Override // com.amazonaws.services.s3.internal.ObjectExpirationResult
        public void d(Date date) {
            CompleteMultipartUploadResult completeMultipartUploadResult = this.c;
            if (completeMultipartUploadResult != null) {
                completeMultipartUploadResult.d(date);
            }
        }

        @Override // com.amazonaws.services.s3.internal.S3RequesterChargedResult
        public void e(boolean z) {
            CompleteMultipartUploadResult completeMultipartUploadResult = this.c;
            if (completeMultipartUploadResult != null) {
                completeMultipartUploadResult.e(z);
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void i(String str, String str2, String str3) {
            AmazonS3Exception amazonS3Exception;
            if (h()) {
                if (!str2.equals("Error") || (amazonS3Exception = this.d) == null) {
                    return;
                }
                amazonS3Exception.f(this.g);
                this.d.i(this.f);
                this.d.p(this.e);
                return;
            }
            if (l("CompleteMultipartUploadResult")) {
                if (str2.equals(HttpHeaders.LOCATION)) {
                    this.c.k(k());
                    return;
                }
                if (str2.equals("Bucket")) {
                    this.c.h(k());
                    return;
                } else if (str2.equals("Key")) {
                    this.c.j(k());
                    return;
                } else {
                    if (str2.equals(HttpHeaders.ETAG)) {
                        this.c.i(ServiceUtils.g(k()));
                        return;
                    }
                    return;
                }
            }
            if (l("Error")) {
                if (str2.equals("Code")) {
                    this.g = k();
                    return;
                }
                if (str2.equals("Message")) {
                    this.d = new AmazonS3Exception(k());
                } else if (str2.equals("RequestId")) {
                    this.f = k();
                } else if (str2.equals("HostId")) {
                    this.e = k();
                }
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void j(String str, String str2, String str3, Attributes attributes) {
            if (h() && str2.equals("CompleteMultipartUploadResult")) {
                this.c = new CompleteMultipartUploadResult();
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractSSEHandler
        public ServerSideEncryptionResult m() {
            return this.c;
        }

        public AmazonS3Exception n() {
            return this.d;
        }

        public CompleteMultipartUploadResult o() {
            return this.c;
        }
    }

    public static class CopyObjectResultHandler extends AbstractSSEHandler implements ObjectExpirationResult, S3RequesterChargedResult, S3VersionResult {
        public final CopyObjectResult c = new CopyObjectResult();

        @Override // com.amazonaws.services.s3.internal.S3VersionResult
        public void a(String str) {
            this.c.a(str);
        }

        @Override // com.amazonaws.services.s3.internal.ObjectExpirationResult
        public void c(String str) {
            this.c.c(str);
        }

        @Override // com.amazonaws.services.s3.internal.ObjectExpirationResult
        public void d(Date date) {
            this.c.d(date);
        }

        @Override // com.amazonaws.services.s3.internal.S3RequesterChargedResult
        public void e(boolean z) {
            this.c.e(z);
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void i(String str, String str2, String str3) {
            if (l("CopyObjectResult") || l("CopyPartResult")) {
                if (str2.equals("LastModified")) {
                    this.c.i(ServiceUtils.e(k()));
                    return;
                } else {
                    if (str2.equals(HttpHeaders.ETAG)) {
                        this.c.h(ServiceUtils.g(k()));
                        return;
                    }
                    return;
                }
            }
            if (l("Error")) {
                if (str2.equals("Code")) {
                    k();
                    return;
                }
                if (str2.equals("Message")) {
                    k();
                } else if (str2.equals("RequestId")) {
                    k();
                } else if (str2.equals("HostId")) {
                    k();
                }
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void j(String str, String str2, String str3, Attributes attributes) {
            if (!h() || str2.equals("CopyObjectResult") || str2.equals("CopyPartResult")) {
                return;
            }
            str2.equals("Error");
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractSSEHandler
        public ServerSideEncryptionResult m() {
            return this.c;
        }
    }

    public static class DeleteObjectsHandler extends AbstractHandler {
        public final DeleteObjectsResponse c = new DeleteObjectsResponse();
        public DeleteObjectsResult$DeletedObject d = null;
        public MultiObjectDeleteException.DeleteError e = null;

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void i(String str, String str2, String str3) {
            if (l("DeleteResult")) {
                if (str2.equals("Deleted")) {
                    this.c.a().add(this.d);
                    this.d = null;
                    return;
                } else {
                    if (str2.equals("Error")) {
                        this.c.b().add(this.e);
                        this.e = null;
                        return;
                    }
                    return;
                }
            }
            if (l("DeleteResult", "Deleted")) {
                if (str2.equals("Key")) {
                    this.d.c(k());
                    return;
                }
                if (str2.equals("VersionId")) {
                    this.d.d(k());
                    return;
                } else if (str2.equals("DeleteMarker")) {
                    this.d.a(k().equals("true"));
                    return;
                } else {
                    if (str2.equals("DeleteMarkerVersionId")) {
                        this.d.b(k());
                        return;
                    }
                    return;
                }
            }
            if (l("DeleteResult", "Error")) {
                if (str2.equals("Key")) {
                    this.e.b(k());
                    return;
                }
                if (str2.equals("VersionId")) {
                    this.e.d(k());
                } else if (str2.equals("Code")) {
                    this.e.a(k());
                } else if (str2.equals("Message")) {
                    this.e.c(k());
                }
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void j(String str, String str2, String str3, Attributes attributes) {
            if (l("DeleteResult")) {
                if (str2.equals("Deleted")) {
                    this.d = new DeleteObjectsResult$DeletedObject();
                } else if (str2.equals("Error")) {
                    this.e = new MultiObjectDeleteException.DeleteError();
                }
            }
        }
    }

    public static class GetBucketAnalyticsConfigurationHandler extends AbstractHandler {
        public final AnalyticsConfiguration c = new AnalyticsConfiguration();
        public AnalyticsFilter d;
        public List<AnalyticsFilterPredicate> e;
        public StorageClassAnalysis f;
        public StorageClassAnalysisDataExport g;
        public AnalyticsExportDestination h;
        public AnalyticsS3BucketDestination i;
        public String j;
        public String k;

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void i(String str, String str2, String str3) {
            if (l("AnalyticsConfiguration")) {
                if (str2.equals("Id")) {
                    this.c.b(k());
                    return;
                } else if (str2.equals("Filter")) {
                    this.c.a(this.d);
                    return;
                } else {
                    if (str2.equals("StorageClassAnalysis")) {
                        this.c.c(this.f);
                        return;
                    }
                    return;
                }
            }
            if (l("AnalyticsConfiguration", "Filter")) {
                if (str2.equals("Prefix")) {
                    this.d.a(new AnalyticsPrefixPredicate(k()));
                    return;
                }
                if (str2.equals("Tag")) {
                    this.d.a(new AnalyticsTagPredicate(new Tag(this.j, this.k)));
                    this.j = null;
                    this.k = null;
                    return;
                } else {
                    if (str2.equals("And")) {
                        this.d.a(new AnalyticsAndOperator(this.e));
                        this.e = null;
                        return;
                    }
                    return;
                }
            }
            if (l("AnalyticsConfiguration", "Filter", "Tag")) {
                if (str2.equals("Key")) {
                    this.j = k();
                    return;
                } else {
                    if (str2.equals("Value")) {
                        this.k = k();
                        return;
                    }
                    return;
                }
            }
            if (l("AnalyticsConfiguration", "Filter", "And")) {
                if (str2.equals("Prefix")) {
                    this.e.add(new AnalyticsPrefixPredicate(k()));
                    return;
                } else {
                    if (str2.equals("Tag")) {
                        this.e.add(new AnalyticsTagPredicate(new Tag(this.j, this.k)));
                        this.j = null;
                        this.k = null;
                        return;
                    }
                    return;
                }
            }
            if (l("AnalyticsConfiguration", "Filter", "And", "Tag")) {
                if (str2.equals("Key")) {
                    this.j = k();
                    return;
                } else {
                    if (str2.equals("Value")) {
                        this.k = k();
                        return;
                    }
                    return;
                }
            }
            if (l("AnalyticsConfiguration", "StorageClassAnalysis")) {
                if (str2.equals("DataExport")) {
                    this.f.a(this.g);
                    return;
                }
                return;
            }
            if (l("AnalyticsConfiguration", "StorageClassAnalysis", "DataExport")) {
                if (str2.equals("OutputSchemaVersion")) {
                    this.g.b(k());
                    return;
                } else {
                    if (str2.equals("Destination")) {
                        this.g.a(this.h);
                        return;
                    }
                    return;
                }
            }
            if (l("AnalyticsConfiguration", "StorageClassAnalysis", "DataExport", "Destination")) {
                if (str2.equals("S3BucketDestination")) {
                    this.h.a(this.i);
                }
            } else if (l("AnalyticsConfiguration", "StorageClassAnalysis", "DataExport", "Destination", "S3BucketDestination")) {
                if (str2.equals("Format")) {
                    this.i.c(k());
                    return;
                }
                if (str2.equals("BucketAccountId")) {
                    this.i.a(k());
                } else if (str2.equals("Bucket")) {
                    this.i.b(k());
                } else if (str2.equals("Prefix")) {
                    this.i.d(k());
                }
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void j(String str, String str2, String str3, Attributes attributes) {
            if (l("AnalyticsConfiguration")) {
                if (str2.equals("Filter")) {
                    this.d = new AnalyticsFilter();
                    return;
                } else {
                    if (str2.equals("StorageClassAnalysis")) {
                        this.f = new StorageClassAnalysis();
                        return;
                    }
                    return;
                }
            }
            if (l("AnalyticsConfiguration", "Filter")) {
                if (str2.equals("And")) {
                    this.e = new ArrayList();
                }
            } else if (l("AnalyticsConfiguration", "StorageClassAnalysis")) {
                if (str2.equals("DataExport")) {
                    this.g = new StorageClassAnalysisDataExport();
                }
            } else if (l("AnalyticsConfiguration", "StorageClassAnalysis", "DataExport")) {
                if (str2.equals("Destination")) {
                    this.h = new AnalyticsExportDestination();
                }
            } else if (l("AnalyticsConfiguration", "StorageClassAnalysis", "DataExport", "Destination") && str2.equals("S3BucketDestination")) {
                this.i = new AnalyticsS3BucketDestination();
            }
        }
    }

    public static class GetBucketInventoryConfigurationHandler extends AbstractHandler {
        public final InventoryConfiguration c = new InventoryConfiguration();
        public List<String> d;
        public InventoryDestination e;
        public InventoryFilter f;
        public InventoryS3BucketDestination g;
        public InventorySchedule h;

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void i(String str, String str2, String str3) {
            if (l("InventoryConfiguration")) {
                if (str2.equals("Id")) {
                    this.c.c(k());
                    return;
                }
                if (str2.equals("Destination")) {
                    this.c.a(this.e);
                    this.e = null;
                    return;
                }
                if (str2.equals("IsEnabled")) {
                    this.c.b(Boolean.valueOf("true".equals(k())));
                    return;
                }
                if (str2.equals("Filter")) {
                    this.c.e(this.f);
                    this.f = null;
                    return;
                }
                if (str2.equals("IncludedObjectVersions")) {
                    this.c.d(k());
                    return;
                }
                if (str2.equals("Schedule")) {
                    this.c.g(this.h);
                    this.h = null;
                    return;
                } else {
                    if (str2.equals("OptionalFields")) {
                        this.c.f(this.d);
                        this.d = null;
                        return;
                    }
                    return;
                }
            }
            if (l("InventoryConfiguration", "Destination")) {
                if (str2.equals("S3BucketDestination")) {
                    this.e.a(this.g);
                    this.g = null;
                    return;
                }
                return;
            }
            if (l("InventoryConfiguration", "Destination", "S3BucketDestination")) {
                if (str2.equals("AccountId")) {
                    this.g.a(k());
                    return;
                }
                if (str2.equals("Bucket")) {
                    this.g.b(k());
                    return;
                } else if (str2.equals("Format")) {
                    this.g.c(k());
                    return;
                } else {
                    if (str2.equals("Prefix")) {
                        this.g.d(k());
                        return;
                    }
                    return;
                }
            }
            if (l("InventoryConfiguration", "Filter")) {
                if (str2.equals("Prefix")) {
                    this.f.a(new InventoryPrefixPredicate(k()));
                }
            } else if (l("InventoryConfiguration", "Schedule")) {
                if (str2.equals("Frequency")) {
                    this.h.a(k());
                }
            } else if (l("InventoryConfiguration", "OptionalFields") && str2.equals("Field")) {
                this.d.add(k());
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void j(String str, String str2, String str3, Attributes attributes) {
            if (!l("InventoryConfiguration")) {
                if (l("InventoryConfiguration", "Destination") && str2.equals("S3BucketDestination")) {
                    this.g = new InventoryS3BucketDestination();
                    return;
                }
                return;
            }
            if (str2.equals("Destination")) {
                this.e = new InventoryDestination();
                return;
            }
            if (str2.equals("Filter")) {
                this.f = new InventoryFilter();
            } else if (str2.equals("Schedule")) {
                this.h = new InventorySchedule();
            } else if (str2.equals("OptionalFields")) {
                this.d = new ArrayList();
            }
        }
    }

    public static class GetBucketMetricsConfigurationHandler extends AbstractHandler {
        public final MetricsConfiguration c = new MetricsConfiguration();
        public MetricsFilter d;
        public List<MetricsFilterPredicate> e;
        public String f;
        public String g;

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void i(String str, String str2, String str3) {
            if (l("MetricsConfiguration")) {
                if (str2.equals("Id")) {
                    this.c.b(k());
                    return;
                } else {
                    if (str2.equals("Filter")) {
                        this.c.a(this.d);
                        this.d = null;
                        return;
                    }
                    return;
                }
            }
            if (l("MetricsConfiguration", "Filter")) {
                if (str2.equals("Prefix")) {
                    this.d.a(new MetricsPrefixPredicate(k()));
                    return;
                }
                if (str2.equals("Tag")) {
                    this.d.a(new MetricsTagPredicate(new Tag(this.f, this.g)));
                    this.f = null;
                    this.g = null;
                    return;
                } else {
                    if (str2.equals("And")) {
                        this.d.a(new MetricsAndOperator(this.e));
                        this.e = null;
                        return;
                    }
                    return;
                }
            }
            if (l("MetricsConfiguration", "Filter", "Tag")) {
                if (str2.equals("Key")) {
                    this.f = k();
                    return;
                } else {
                    if (str2.equals("Value")) {
                        this.g = k();
                        return;
                    }
                    return;
                }
            }
            if (l("MetricsConfiguration", "Filter", "And")) {
                if (str2.equals("Prefix")) {
                    this.e.add(new MetricsPrefixPredicate(k()));
                    return;
                } else {
                    if (str2.equals("Tag")) {
                        this.e.add(new MetricsTagPredicate(new Tag(this.f, this.g)));
                        this.f = null;
                        this.g = null;
                        return;
                    }
                    return;
                }
            }
            if (l("MetricsConfiguration", "Filter", "And", "Tag")) {
                if (str2.equals("Key")) {
                    this.f = k();
                } else if (str2.equals("Value")) {
                    this.g = k();
                }
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void j(String str, String str2, String str3, Attributes attributes) {
            if (l("MetricsConfiguration")) {
                if (str2.equals("Filter")) {
                    this.d = new MetricsFilter();
                }
            } else if (l("MetricsConfiguration", "Filter") && str2.equals("And")) {
                this.e = new ArrayList();
            }
        }
    }

    public static class GetObjectTaggingHandler extends AbstractHandler {
        public List<Tag> c;
        public String d;
        public String e;

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void i(String str, String str2, String str3) {
            if (l("Tagging") && str2.equals("TagSet")) {
                this.c = null;
            }
            if (l("Tagging", "TagSet")) {
                if (str2.equals("Tag")) {
                    this.c.add(new Tag(this.e, this.d));
                    this.e = null;
                    this.d = null;
                    return;
                }
                return;
            }
            if (l("Tagging", "TagSet", "Tag")) {
                if (str2.equals("Key")) {
                    this.e = k();
                } else if (str2.equals("Value")) {
                    this.d = k();
                }
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void j(String str, String str2, String str3, Attributes attributes) {
            if (l("Tagging") && str2.equals("TagSet")) {
                this.c = new ArrayList();
            }
        }
    }

    public static class InitiateMultipartUploadHandler extends AbstractHandler {
        public final InitiateMultipartUploadResult c = new InitiateMultipartUploadResult();

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void i(String str, String str2, String str3) {
            if (l("InitiateMultipartUploadResult")) {
                if (str2.equals("Bucket")) {
                    this.c.i(k());
                } else if (str2.equals("Key")) {
                    this.c.j(k());
                } else if (str2.equals("UploadId")) {
                    this.c.k(k());
                }
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void j(String str, String str2, String str3, Attributes attributes) {
        }

        public InitiateMultipartUploadResult m() {
            return this.c;
        }
    }

    public static class ListAllMyBucketsHandler extends AbstractHandler {
        public final List<Bucket> c = new ArrayList();
        public Owner d = null;
        public Bucket e = null;

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void i(String str, String str2, String str3) {
            if (l("ListAllMyBucketsResult", "Owner")) {
                if (str2.equals("ID")) {
                    this.d.d(k());
                    return;
                } else {
                    if (str2.equals("DisplayName")) {
                        this.d.c(k());
                        return;
                    }
                    return;
                }
            }
            if (l("ListAllMyBucketsResult", "Buckets")) {
                if (str2.equals("Bucket")) {
                    this.c.add(this.e);
                    this.e = null;
                    return;
                }
                return;
            }
            if (l("ListAllMyBucketsResult", "Buckets", "Bucket")) {
                if (str2.equals("Name")) {
                    this.e.d(k());
                } else if (str2.equals("CreationDate")) {
                    this.e.c(DateUtils.h(k()));
                }
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void j(String str, String str2, String str3, Attributes attributes) {
            if (l("ListAllMyBucketsResult")) {
                if (str2.equals("Owner")) {
                    this.d = new Owner();
                }
            } else if (l("ListAllMyBucketsResult", "Buckets") && str2.equals("Bucket")) {
                Bucket bucket = new Bucket();
                this.e = bucket;
                bucket.e(this.d);
            }
        }
    }

    public static class ListBucketAnalyticsConfigurationHandler extends AbstractHandler {
        public final ListBucketAnalyticsConfigurationsResult c = new ListBucketAnalyticsConfigurationsResult();
        public AnalyticsConfiguration d;
        public AnalyticsFilter e;
        public List<AnalyticsFilterPredicate> f;
        public StorageClassAnalysis g;
        public StorageClassAnalysisDataExport h;
        public AnalyticsExportDestination i;
        public AnalyticsS3BucketDestination j;
        public String k;
        public String l;

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void i(String str, String str2, String str3) {
            if (l("ListBucketAnalyticsConfigurationsResult")) {
                if (str2.equals("AnalyticsConfiguration")) {
                    if (this.c.a() == null) {
                        this.c.b(new ArrayList());
                    }
                    this.c.a().add(this.d);
                    this.d = null;
                    return;
                }
                if (str2.equals("IsTruncated")) {
                    this.c.e("true".equals(k()));
                    return;
                } else if (str2.equals("ContinuationToken")) {
                    this.c.c(k());
                    return;
                } else {
                    if (str2.equals("NextContinuationToken")) {
                        this.c.d(k());
                        return;
                    }
                    return;
                }
            }
            if (l("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration")) {
                if (str2.equals("Id")) {
                    this.d.b(k());
                    return;
                } else if (str2.equals("Filter")) {
                    this.d.a(this.e);
                    return;
                } else {
                    if (str2.equals("StorageClassAnalysis")) {
                        this.d.c(this.g);
                        return;
                    }
                    return;
                }
            }
            if (l("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "Filter")) {
                if (str2.equals("Prefix")) {
                    this.e.a(new AnalyticsPrefixPredicate(k()));
                    return;
                }
                if (str2.equals("Tag")) {
                    this.e.a(new AnalyticsTagPredicate(new Tag(this.k, this.l)));
                    this.k = null;
                    this.l = null;
                    return;
                } else {
                    if (str2.equals("And")) {
                        this.e.a(new AnalyticsAndOperator(this.f));
                        this.f = null;
                        return;
                    }
                    return;
                }
            }
            if (l("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "Filter", "Tag")) {
                if (str2.equals("Key")) {
                    this.k = k();
                    return;
                } else {
                    if (str2.equals("Value")) {
                        this.l = k();
                        return;
                    }
                    return;
                }
            }
            if (l("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "Filter", "And")) {
                if (str2.equals("Prefix")) {
                    this.f.add(new AnalyticsPrefixPredicate(k()));
                    return;
                } else {
                    if (str2.equals("Tag")) {
                        this.f.add(new AnalyticsTagPredicate(new Tag(this.k, this.l)));
                        this.k = null;
                        this.l = null;
                        return;
                    }
                    return;
                }
            }
            if (l("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "Filter", "And", "Tag")) {
                if (str2.equals("Key")) {
                    this.k = k();
                    return;
                } else {
                    if (str2.equals("Value")) {
                        this.l = k();
                        return;
                    }
                    return;
                }
            }
            if (l("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "StorageClassAnalysis")) {
                if (str2.equals("DataExport")) {
                    this.g.a(this.h);
                    return;
                }
                return;
            }
            if (l("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "StorageClassAnalysis", "DataExport")) {
                if (str2.equals("OutputSchemaVersion")) {
                    this.h.b(k());
                    return;
                } else {
                    if (str2.equals("Destination")) {
                        this.h.a(this.i);
                        return;
                    }
                    return;
                }
            }
            if (l("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "StorageClassAnalysis", "DataExport", "Destination")) {
                if (str2.equals("S3BucketDestination")) {
                    this.i.a(this.j);
                }
            } else if (l("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "StorageClassAnalysis", "DataExport", "Destination", "S3BucketDestination")) {
                if (str2.equals("Format")) {
                    this.j.c(k());
                    return;
                }
                if (str2.equals("BucketAccountId")) {
                    this.j.a(k());
                } else if (str2.equals("Bucket")) {
                    this.j.b(k());
                } else if (str2.equals("Prefix")) {
                    this.j.d(k());
                }
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void j(String str, String str2, String str3, Attributes attributes) {
            if (l("ListBucketAnalyticsConfigurationsResult")) {
                if (str2.equals("AnalyticsConfiguration")) {
                    this.d = new AnalyticsConfiguration();
                    return;
                }
                return;
            }
            if (l("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration")) {
                if (str2.equals("Filter")) {
                    this.e = new AnalyticsFilter();
                    return;
                } else {
                    if (str2.equals("StorageClassAnalysis")) {
                        this.g = new StorageClassAnalysis();
                        return;
                    }
                    return;
                }
            }
            if (l("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "Filter")) {
                if (str2.equals("And")) {
                    this.f = new ArrayList();
                }
            } else if (l("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "StorageClassAnalysis")) {
                if (str2.equals("DataExport")) {
                    this.h = new StorageClassAnalysisDataExport();
                }
            } else if (l("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "StorageClassAnalysis", "DataExport")) {
                if (str2.equals("Destination")) {
                    this.i = new AnalyticsExportDestination();
                }
            } else if (l("ListBucketAnalyticsConfigurationsResult", "AnalyticsConfiguration", "StorageClassAnalysis", "DataExport", "Destination") && str2.equals("S3BucketDestination")) {
                this.j = new AnalyticsS3BucketDestination();
            }
        }
    }

    public static class ListBucketHandler extends AbstractHandler {
        public final ObjectListing c;
        public final boolean d;
        public S3ObjectSummary e;
        public Owner f;
        public String g;

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void i(String str, String str2, String str3) {
            String strA = null;
            if (h()) {
                if (str2.equals("ListBucketResult") && this.c.e() && this.c.c() == null) {
                    if (!this.c.d().isEmpty()) {
                        strA = this.c.d().get(this.c.d().size() - 1).a();
                    } else if (this.c.b().isEmpty()) {
                        XmlResponsesSaxParser.b.d("S3 response indicates truncated results, but contains no object summaries or common prefixes.");
                    } else {
                        strA = this.c.b().get(this.c.b().size() - 1);
                    }
                    this.c.k(strA);
                    return;
                }
                return;
            }
            if (!l("ListBucketResult")) {
                if (!l("ListBucketResult", "Contents")) {
                    if (!l("ListBucketResult", "Contents", "Owner")) {
                        if (l("ListBucketResult", "CommonPrefixes") && str2.equals("Prefix")) {
                            this.c.b().add(XmlResponsesSaxParser.h(k(), this.d));
                            return;
                        }
                        return;
                    }
                    if (str2.equals("ID")) {
                        this.f.d(k());
                        return;
                    } else {
                        if (str2.equals("DisplayName")) {
                            this.f.c(k());
                            return;
                        }
                        return;
                    }
                }
                if (str2.equals("Key")) {
                    String strK = k();
                    this.g = strK;
                    this.e.d(XmlResponsesSaxParser.h(strK, this.d));
                    return;
                }
                if (str2.equals("LastModified")) {
                    this.e.e(ServiceUtils.e(k()));
                    return;
                }
                if (str2.equals(HttpHeaders.ETAG)) {
                    this.e.c(ServiceUtils.g(k()));
                    return;
                }
                if (str2.equals("Size")) {
                    this.e.g(XmlResponsesSaxParser.m(k()));
                    return;
                }
                if (str2.equals("StorageClass")) {
                    this.e.h(k());
                    return;
                } else {
                    if (str2.equals("Owner")) {
                        this.e.f(this.f);
                        this.f = null;
                        return;
                    }
                    return;
                }
            }
            if (str2.equals("Name")) {
                this.c.f(k());
                if (XmlResponsesSaxParser.b.isDebugEnabled()) {
                    XmlResponsesSaxParser.b.a("Examining listing for bucket: " + this.c.a());
                    return;
                }
                return;
            }
            if (str2.equals("Prefix")) {
                this.c.l(XmlResponsesSaxParser.h(XmlResponsesSaxParser.g(k()), this.d));
                return;
            }
            if (str2.equals("Marker")) {
                this.c.i(XmlResponsesSaxParser.h(XmlResponsesSaxParser.g(k()), this.d));
                return;
            }
            if (str2.equals("NextMarker")) {
                this.c.k(XmlResponsesSaxParser.h(k(), this.d));
                return;
            }
            if (str2.equals("MaxKeys")) {
                this.c.j(XmlResponsesSaxParser.l(k()));
                return;
            }
            if (str2.equals("Delimiter")) {
                this.c.g(XmlResponsesSaxParser.h(XmlResponsesSaxParser.g(k()), this.d));
                return;
            }
            if (str2.equals("EncodingType")) {
                this.c.h(XmlResponsesSaxParser.g(k()));
                return;
            }
            if (!str2.equals("IsTruncated")) {
                if (str2.equals("Contents")) {
                    this.c.d().add(this.e);
                    this.e = null;
                    return;
                }
                return;
            }
            String strB = StringUtils.b(k());
            if (strB.startsWith("false")) {
                this.c.m(false);
            } else {
                if (strB.startsWith("true")) {
                    this.c.m(true);
                    return;
                }
                throw new IllegalStateException("Invalid value for IsTruncated field: " + strB);
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void j(String str, String str2, String str3, Attributes attributes) {
            if (!l("ListBucketResult")) {
                if (l("ListBucketResult", "Contents") && str2.equals("Owner")) {
                    this.f = new Owner();
                    return;
                }
                return;
            }
            if (str2.equals("Contents")) {
                S3ObjectSummary s3ObjectSummary = new S3ObjectSummary();
                this.e = s3ObjectSummary;
                s3ObjectSummary.b(this.c.a());
            }
        }
    }

    public static class ListBucketInventoryConfigurationsHandler extends AbstractHandler {
        public final ListBucketInventoryConfigurationsResult c = new ListBucketInventoryConfigurationsResult();
        public InventoryConfiguration d;
        public List<String> e;
        public InventoryDestination f;
        public InventoryFilter g;
        public InventoryS3BucketDestination h;
        public InventorySchedule i;

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void i(String str, String str2, String str3) {
            if (l("ListInventoryConfigurationsResult")) {
                if (str2.equals("InventoryConfiguration")) {
                    if (this.c.a() == null) {
                        this.c.c(new ArrayList());
                    }
                    this.c.a().add(this.d);
                    this.d = null;
                    return;
                }
                if (str2.equals("IsTruncated")) {
                    this.c.e("true".equals(k()));
                    return;
                } else if (str2.equals("ContinuationToken")) {
                    this.c.b(k());
                    return;
                } else {
                    if (str2.equals("NextContinuationToken")) {
                        this.c.d(k());
                        return;
                    }
                    return;
                }
            }
            if (l("ListInventoryConfigurationsResult", "InventoryConfiguration")) {
                if (str2.equals("Id")) {
                    this.d.c(k());
                    return;
                }
                if (str2.equals("Destination")) {
                    this.d.a(this.f);
                    this.f = null;
                    return;
                }
                if (str2.equals("IsEnabled")) {
                    this.d.b(Boolean.valueOf("true".equals(k())));
                    return;
                }
                if (str2.equals("Filter")) {
                    this.d.e(this.g);
                    this.g = null;
                    return;
                }
                if (str2.equals("IncludedObjectVersions")) {
                    this.d.d(k());
                    return;
                }
                if (str2.equals("Schedule")) {
                    this.d.g(this.i);
                    this.i = null;
                    return;
                } else {
                    if (str2.equals("OptionalFields")) {
                        this.d.f(this.e);
                        this.e = null;
                        return;
                    }
                    return;
                }
            }
            if (l("ListInventoryConfigurationsResult", "InventoryConfiguration", "Destination")) {
                if (str2.equals("S3BucketDestination")) {
                    this.f.a(this.h);
                    this.h = null;
                    return;
                }
                return;
            }
            if (l("ListInventoryConfigurationsResult", "InventoryConfiguration", "Destination", "S3BucketDestination")) {
                if (str2.equals("AccountId")) {
                    this.h.a(k());
                    return;
                }
                if (str2.equals("Bucket")) {
                    this.h.b(k());
                    return;
                } else if (str2.equals("Format")) {
                    this.h.c(k());
                    return;
                } else {
                    if (str2.equals("Prefix")) {
                        this.h.d(k());
                        return;
                    }
                    return;
                }
            }
            if (l("ListInventoryConfigurationsResult", "InventoryConfiguration", "Filter")) {
                if (str2.equals("Prefix")) {
                    this.g.a(new InventoryPrefixPredicate(k()));
                }
            } else if (l("ListInventoryConfigurationsResult", "InventoryConfiguration", "Schedule")) {
                if (str2.equals("Frequency")) {
                    this.i.a(k());
                }
            } else if (l("ListInventoryConfigurationsResult", "InventoryConfiguration", "OptionalFields") && str2.equals("Field")) {
                this.e.add(k());
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void j(String str, String str2, String str3, Attributes attributes) {
            if (l("ListInventoryConfigurationsResult")) {
                if (str2.equals("InventoryConfiguration")) {
                    this.d = new InventoryConfiguration();
                    return;
                }
                return;
            }
            if (!l("ListInventoryConfigurationsResult", "InventoryConfiguration")) {
                if (l("ListInventoryConfigurationsResult", "InventoryConfiguration", "Destination") && str2.equals("S3BucketDestination")) {
                    this.h = new InventoryS3BucketDestination();
                    return;
                }
                return;
            }
            if (str2.equals("Destination")) {
                this.f = new InventoryDestination();
                return;
            }
            if (str2.equals("Filter")) {
                this.g = new InventoryFilter();
            } else if (str2.equals("Schedule")) {
                this.i = new InventorySchedule();
            } else if (str2.equals("OptionalFields")) {
                this.e = new ArrayList();
            }
        }
    }

    public static class ListBucketMetricsConfigurationsHandler extends AbstractHandler {
        public final ListBucketMetricsConfigurationsResult c = new ListBucketMetricsConfigurationsResult();
        public MetricsConfiguration d;
        public MetricsFilter e;
        public List<MetricsFilterPredicate> f;
        public String g;
        public String h;

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void i(String str, String str2, String str3) {
            if (l("ListMetricsConfigurationsResult")) {
                if (str2.equals("MetricsConfiguration")) {
                    if (this.c.a() == null) {
                        this.c.c(new ArrayList());
                    }
                    this.c.a().add(this.d);
                    this.d = null;
                    return;
                }
                if (str2.equals("IsTruncated")) {
                    this.c.e("true".equals(k()));
                    return;
                } else if (str2.equals("ContinuationToken")) {
                    this.c.b(k());
                    return;
                } else {
                    if (str2.equals("NextContinuationToken")) {
                        this.c.d(k());
                        return;
                    }
                    return;
                }
            }
            if (l("ListMetricsConfigurationsResult", "MetricsConfiguration")) {
                if (str2.equals("Id")) {
                    this.d.b(k());
                    return;
                } else {
                    if (str2.equals("Filter")) {
                        this.d.a(this.e);
                        this.e = null;
                        return;
                    }
                    return;
                }
            }
            if (l("ListMetricsConfigurationsResult", "MetricsConfiguration", "Filter")) {
                if (str2.equals("Prefix")) {
                    this.e.a(new MetricsPrefixPredicate(k()));
                    return;
                }
                if (str2.equals("Tag")) {
                    this.e.a(new MetricsTagPredicate(new Tag(this.g, this.h)));
                    this.g = null;
                    this.h = null;
                    return;
                } else {
                    if (str2.equals("And")) {
                        this.e.a(new MetricsAndOperator(this.f));
                        this.f = null;
                        return;
                    }
                    return;
                }
            }
            if (l("ListMetricsConfigurationsResult", "MetricsConfiguration", "Filter", "Tag")) {
                if (str2.equals("Key")) {
                    this.g = k();
                    return;
                } else {
                    if (str2.equals("Value")) {
                        this.h = k();
                        return;
                    }
                    return;
                }
            }
            if (l("ListMetricsConfigurationsResult", "MetricsConfiguration", "Filter", "And")) {
                if (str2.equals("Prefix")) {
                    this.f.add(new MetricsPrefixPredicate(k()));
                    return;
                } else {
                    if (str2.equals("Tag")) {
                        this.f.add(new MetricsTagPredicate(new Tag(this.g, this.h)));
                        this.g = null;
                        this.h = null;
                        return;
                    }
                    return;
                }
            }
            if (l("ListMetricsConfigurationsResult", "MetricsConfiguration", "Filter", "And", "Tag")) {
                if (str2.equals("Key")) {
                    this.g = k();
                } else if (str2.equals("Value")) {
                    this.h = k();
                }
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void j(String str, String str2, String str3, Attributes attributes) {
            if (l("ListMetricsConfigurationsResult")) {
                if (str2.equals("MetricsConfiguration")) {
                    this.d = new MetricsConfiguration();
                }
            } else if (l("ListMetricsConfigurationsResult", "MetricsConfiguration")) {
                if (str2.equals("Filter")) {
                    this.e = new MetricsFilter();
                }
            } else if (l("ListMetricsConfigurationsResult", "MetricsConfiguration", "Filter") && str2.equals("And")) {
                this.f = new ArrayList();
            }
        }
    }

    public static class ListMultipartUploadsHandler extends AbstractHandler {
        public final MultipartUploadListing c = new MultipartUploadListing();
        public MultipartUpload d;
        public Owner e;

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void i(String str, String str2, String str3) {
            if (l("ListMultipartUploadsResult")) {
                if (str2.equals("Bucket")) {
                    this.c.c(k());
                    return;
                }
                if (str2.equals("KeyMarker")) {
                    this.c.f(XmlResponsesSaxParser.g(k()));
                    return;
                }
                if (str2.equals("Delimiter")) {
                    this.c.d(XmlResponsesSaxParser.g(k()));
                    return;
                }
                if (str2.equals("Prefix")) {
                    this.c.j(XmlResponsesSaxParser.g(k()));
                    return;
                }
                if (str2.equals("UploadIdMarker")) {
                    this.c.l(XmlResponsesSaxParser.g(k()));
                    return;
                }
                if (str2.equals("NextKeyMarker")) {
                    this.c.h(XmlResponsesSaxParser.g(k()));
                    return;
                }
                if (str2.equals("NextUploadIdMarker")) {
                    this.c.i(XmlResponsesSaxParser.g(k()));
                    return;
                }
                if (str2.equals("MaxUploads")) {
                    this.c.g(Integer.parseInt(k()));
                    return;
                }
                if (str2.equals("EncodingType")) {
                    this.c.e(XmlResponsesSaxParser.g(k()));
                    return;
                }
                if (str2.equals("IsTruncated")) {
                    this.c.k(Boolean.parseBoolean(k()));
                    return;
                } else {
                    if (str2.equals("Upload")) {
                        this.c.b().add(this.d);
                        this.d = null;
                        return;
                    }
                    return;
                }
            }
            if (l("ListMultipartUploadsResult", "CommonPrefixes")) {
                if (str2.equals("Prefix")) {
                    this.c.a().add(k());
                    return;
                }
                return;
            }
            if (!l("ListMultipartUploadsResult", "Upload")) {
                if (l("ListMultipartUploadsResult", "Upload", "Owner") || l("ListMultipartUploadsResult", "Upload", "Initiator")) {
                    if (str2.equals("ID")) {
                        this.e.d(XmlResponsesSaxParser.g(k()));
                        return;
                    } else {
                        if (str2.equals("DisplayName")) {
                            this.e.c(XmlResponsesSaxParser.g(k()));
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            if (str2.equals("Key")) {
                this.d.c(k());
                return;
            }
            if (str2.equals("UploadId")) {
                this.d.f(k());
                return;
            }
            if (str2.equals("Owner")) {
                this.d.d(this.e);
                this.e = null;
            } else if (str2.equals("Initiator")) {
                this.d.b(this.e);
                this.e = null;
            } else if (str2.equals("StorageClass")) {
                this.d.e(k());
            } else if (str2.equals("Initiated")) {
                this.d.a(ServiceUtils.e(k()));
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void j(String str, String str2, String str3, Attributes attributes) {
            if (l("ListMultipartUploadsResult")) {
                if (str2.equals("Upload")) {
                    this.d = new MultipartUpload();
                }
            } else if (l("ListMultipartUploadsResult", "Upload")) {
                if (str2.equals("Owner") || str2.equals("Initiator")) {
                    this.e = new Owner();
                }
            }
        }
    }

    public static class ListObjectsV2Handler extends AbstractHandler {
        public final ListObjectsV2Result c;
        public final boolean d;
        public S3ObjectSummary e;
        public Owner f;
        public String g;

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void i(String str, String str2, String str3) {
            if (h()) {
                if (str2.equals("ListBucketResult")) {
                    this.c.d();
                    throw null;
                }
                return;
            }
            if (!l("ListBucketResult")) {
                if (!l("ListBucketResult", "Contents")) {
                    if (!l("ListBucketResult", "Contents", "Owner")) {
                        if (l("ListBucketResult", "CommonPrefixes") && str2.equals("Prefix")) {
                            this.c.b();
                            throw null;
                        }
                        return;
                    }
                    if (str2.equals("ID")) {
                        this.f.d(k());
                        return;
                    } else {
                        if (str2.equals("DisplayName")) {
                            this.f.c(k());
                            return;
                        }
                        return;
                    }
                }
                if (str2.equals("Key")) {
                    String strK = k();
                    this.g = strK;
                    this.e.d(XmlResponsesSaxParser.h(strK, this.d));
                    return;
                }
                if (str2.equals("LastModified")) {
                    this.e.e(ServiceUtils.e(k()));
                    return;
                }
                if (str2.equals(HttpHeaders.ETAG)) {
                    this.e.c(ServiceUtils.g(k()));
                    return;
                }
                if (str2.equals("Size")) {
                    this.e.g(XmlResponsesSaxParser.m(k()));
                    return;
                }
                if (str2.equals("StorageClass")) {
                    this.e.h(k());
                    return;
                } else {
                    if (str2.equals("Owner")) {
                        this.e.f(this.f);
                        this.f = null;
                        return;
                    }
                    return;
                }
            }
            if (str2.equals("Name")) {
                this.c.e(k());
                throw null;
            }
            if (str2.equals("Prefix")) {
                this.c.l(XmlResponsesSaxParser.h(XmlResponsesSaxParser.g(k()), this.d));
                throw null;
            }
            if (str2.equals("MaxKeys")) {
                this.c.j(XmlResponsesSaxParser.l(k()));
                throw null;
            }
            if (str2.equals("NextContinuationToken")) {
                this.c.k(k());
                throw null;
            }
            if (str2.equals("ContinuationToken")) {
                this.c.f(k());
                throw null;
            }
            if (str2.equals("StartAfter")) {
                this.c.m(XmlResponsesSaxParser.h(k(), this.d));
                throw null;
            }
            if (str2.equals("KeyCount")) {
                this.c.i(XmlResponsesSaxParser.l(k()));
                throw null;
            }
            if (str2.equals("Delimiter")) {
                this.c.g(XmlResponsesSaxParser.h(XmlResponsesSaxParser.g(k()), this.d));
                throw null;
            }
            if (str2.equals("EncodingType")) {
                this.c.h(XmlResponsesSaxParser.g(k()));
                throw null;
            }
            if (!str2.equals("IsTruncated")) {
                if (str2.equals("Contents")) {
                    this.c.c();
                    throw null;
                }
                return;
            }
            String strB = StringUtils.b(k());
            if (strB.startsWith("false")) {
                this.c.n(false);
                throw null;
            }
            if (strB.startsWith("true")) {
                this.c.n(true);
                throw null;
            }
            throw new IllegalStateException("Invalid value for IsTruncated field: " + strB);
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void j(String str, String str2, String str3, Attributes attributes) {
            if (l("ListBucketResult")) {
                if (str2.equals("Contents")) {
                    this.e = new S3ObjectSummary();
                    this.c.a();
                    throw null;
                }
                return;
            }
            if (l("ListBucketResult", "Contents") && str2.equals("Owner")) {
                this.f = new Owner();
            }
        }
    }

    public static class ListPartsHandler extends AbstractHandler {
        public final PartListing c = new PartListing();
        public PartSummary d;
        public Owner e;

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void i(String str, String str2, String str3) {
            if (!l("ListPartsResult")) {
                if (!l("ListPartsResult", "Part")) {
                    if (l("ListPartsResult", "Owner") || l("ListPartsResult", "Initiator")) {
                        if (str2.equals("ID")) {
                            this.e.d(XmlResponsesSaxParser.g(k()));
                            return;
                        } else {
                            if (str2.equals("DisplayName")) {
                                this.e.c(XmlResponsesSaxParser.g(k()));
                                return;
                            }
                            return;
                        }
                    }
                    return;
                }
                if (str2.equals("PartNumber")) {
                    this.d.c(Integer.parseInt(k()));
                    return;
                }
                if (str2.equals("LastModified")) {
                    this.d.b(ServiceUtils.e(k()));
                    return;
                } else if (str2.equals(HttpHeaders.ETAG)) {
                    this.d.a(ServiceUtils.g(k()));
                    return;
                } else {
                    if (str2.equals("Size")) {
                        this.d.d(Long.parseLong(k()));
                        return;
                    }
                    return;
                }
            }
            if (str2.equals("Bucket")) {
                this.c.b(k());
                return;
            }
            if (str2.equals("Key")) {
                this.c.f(k());
                return;
            }
            if (str2.equals("UploadId")) {
                this.c.m(k());
                return;
            }
            if (str2.equals("Owner")) {
                this.c.i(this.e);
                this.e = null;
                return;
            }
            if (str2.equals("Initiator")) {
                this.c.d(this.e);
                this.e = null;
                return;
            }
            if (str2.equals("StorageClass")) {
                this.c.k(k());
                return;
            }
            if (str2.equals("PartNumberMarker")) {
                this.c.j(m(k()).intValue());
                return;
            }
            if (str2.equals("NextPartNumberMarker")) {
                this.c.h(m(k()).intValue());
                return;
            }
            if (str2.equals("MaxParts")) {
                this.c.g(m(k()).intValue());
                return;
            }
            if (str2.equals("EncodingType")) {
                this.c.c(XmlResponsesSaxParser.g(k()));
                return;
            }
            if (str2.equals("IsTruncated")) {
                this.c.l(Boolean.parseBoolean(k()));
            } else if (str2.equals("Part")) {
                this.c.a().add(this.d);
                this.d = null;
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void j(String str, String str2, String str3, Attributes attributes) {
            if (l("ListPartsResult")) {
                if (str2.equals("Part")) {
                    this.d = new PartSummary();
                } else if (str2.equals("Owner") || str2.equals("Initiator")) {
                    this.e = new Owner();
                }
            }
        }

        public final Integer m(String str) {
            String strG = XmlResponsesSaxParser.g(k());
            if (strG == null) {
                return null;
            }
            return Integer.valueOf(Integer.parseInt(strG));
        }
    }

    public static class ListVersionsHandler extends AbstractHandler {
        public final VersionListing c;
        public final boolean d;
        public S3VersionSummary e;
        public Owner f;

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void i(String str, String str2, String str3) {
            if (l("ListVersionsResult")) {
                if (str2.equals("Name")) {
                    this.c.d(k());
                    throw null;
                }
                if (str2.equals("Prefix")) {
                    this.c.k(XmlResponsesSaxParser.h(XmlResponsesSaxParser.g(k()), this.d));
                    throw null;
                }
                if (str2.equals("KeyMarker")) {
                    this.c.g(XmlResponsesSaxParser.h(XmlResponsesSaxParser.g(k()), this.d));
                    throw null;
                }
                if (str2.equals("VersionIdMarker")) {
                    this.c.m(XmlResponsesSaxParser.g(k()));
                    throw null;
                }
                if (str2.equals("MaxKeys")) {
                    this.c.h(Integer.parseInt(k()));
                    throw null;
                }
                if (str2.equals("Delimiter")) {
                    this.c.e(XmlResponsesSaxParser.h(XmlResponsesSaxParser.g(k()), this.d));
                    throw null;
                }
                if (str2.equals("EncodingType")) {
                    this.c.f(XmlResponsesSaxParser.g(k()));
                    throw null;
                }
                if (str2.equals("NextKeyMarker")) {
                    this.c.i(XmlResponsesSaxParser.h(XmlResponsesSaxParser.g(k()), this.d));
                    throw null;
                }
                if (str2.equals("NextVersionIdMarker")) {
                    this.c.j(k());
                    throw null;
                }
                if (str2.equals("IsTruncated")) {
                    this.c.l("true".equals(k()));
                    throw null;
                }
                if (str2.equals("Version") || str2.equals("DeleteMarker")) {
                    this.c.c();
                    throw null;
                }
                return;
            }
            if (l("ListVersionsResult", "CommonPrefixes")) {
                if (str2.equals("Prefix")) {
                    XmlResponsesSaxParser.g(k());
                    this.c.b();
                    throw null;
                }
                return;
            }
            if (!l("ListVersionsResult", "Version") && !l("ListVersionsResult", "DeleteMarker")) {
                if (l("ListVersionsResult", "Version", "Owner") || l("ListVersionsResult", "DeleteMarker", "Owner")) {
                    if (str2.equals("ID")) {
                        this.f.d(k());
                        return;
                    } else {
                        if (str2.equals("DisplayName")) {
                            this.f.c(k());
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            if (str2.equals("Key")) {
                this.e.c(XmlResponsesSaxParser.h(k(), this.d));
                return;
            }
            if (str2.equals("VersionId")) {
                this.e.h(k());
                return;
            }
            if (str2.equals("IsLatest")) {
                this.e.b("true".equals(k()));
                return;
            }
            if (str2.equals("LastModified")) {
                this.e.d(ServiceUtils.e(k()));
                return;
            }
            if (str2.equals(HttpHeaders.ETAG)) {
                this.e.a(ServiceUtils.g(k()));
                return;
            }
            if (str2.equals("Size")) {
                this.e.f(Long.parseLong(k()));
                return;
            }
            if (str2.equals("Owner")) {
                this.e.e(this.f);
                this.f = null;
            } else if (str2.equals("StorageClass")) {
                this.e.g(k());
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void j(String str, String str2, String str3, Attributes attributes) {
            if (!l("ListVersionsResult")) {
                if ((l("ListVersionsResult", "Version") || l("ListVersionsResult", "DeleteMarker")) && str2.equals("Owner")) {
                    this.f = new Owner();
                    return;
                }
                return;
            }
            if (str2.equals("Version")) {
                this.e = new S3VersionSummary();
                this.c.a();
                throw null;
            }
            if (str2.equals("DeleteMarker")) {
                this.e = new S3VersionSummary();
                this.c.a();
                throw null;
            }
        }
    }

    public static class RequestPaymentConfigurationHandler extends AbstractHandler {
        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void i(String str, String str2, String str3) {
            if (l("RequestPaymentConfiguration") && str2.equals("Payer")) {
                k();
            }
        }

        @Override // com.amazonaws.services.s3.model.transform.AbstractHandler
        public void j(String str, String str2, String str3, Attributes attributes) {
        }
    }

    public XmlResponsesSaxParser() throws AmazonClientException {
        this.a = null;
        try {
            this.a = XMLReaderFactory.createXMLReader();
        } catch (SAXException e) {
            System.setProperty("org.xml.sax.driver", "org.xmlpull.v1.sax2.Driver");
            try {
                this.a = XMLReaderFactory.createXMLReader();
            } catch (SAXException unused) {
                throw new AmazonClientException("Couldn't initialize a sax driver for the XMLReader", e);
            }
        }
    }

    public static String g(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }
        return str;
    }

    public static String h(String str, boolean z) {
        return z ? S3HttpUtils.a(str) : str;
    }

    public static String i(String str, Attributes attributes) {
        if (!StringUtils.a(str) && attributes != null) {
            for (int i = 0; i < attributes.getLength(); i++) {
                if (attributes.getQName(i).trim().equalsIgnoreCase(str.trim())) {
                    return attributes.getValue(i);
                }
            }
        }
        return null;
    }

    public static int l(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            b.c("Unable to parse integer value '" + str + "'", e);
            return -1;
        }
    }

    public static long m(String str) {
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException e) {
            b.c("Unable to parse long value '" + str + "'", e);
            return -1L;
        }
    }

    public CompleteMultipartUploadHandler j(InputStream inputStream) throws IOException {
        CompleteMultipartUploadHandler completeMultipartUploadHandler = new CompleteMultipartUploadHandler();
        n(completeMultipartUploadHandler, inputStream);
        return completeMultipartUploadHandler;
    }

    public InitiateMultipartUploadHandler k(InputStream inputStream) throws IOException {
        InitiateMultipartUploadHandler initiateMultipartUploadHandler = new InitiateMultipartUploadHandler();
        n(initiateMultipartUploadHandler, inputStream);
        return initiateMultipartUploadHandler;
    }

    public void n(DefaultHandler defaultHandler, InputStream inputStream) throws IOException {
        try {
            Log log = b;
            if (log.isDebugEnabled()) {
                log.a("Parsing XML response document with handler: " + defaultHandler.getClass());
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            this.a.setContentHandler(defaultHandler);
            this.a.setErrorHandler(defaultHandler);
            this.a.parse(new InputSource(bufferedReader));
        } catch (IOException e) {
            throw e;
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (IOException e2) {
                if (b.isErrorEnabled()) {
                    b.c("Unable to close response InputStream up after XML parse failure", e2);
                }
            }
            throw new AmazonClientException("Failed to parse XML document with handler " + defaultHandler.getClass(), th);
        }
    }
}
